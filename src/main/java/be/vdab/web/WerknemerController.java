package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
public class WerknemerController {

	// VIEWS
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_VIEW = "werknemers/opslag";

	private final WerknemerService werknemerService;

	// CONSTRUCTOR
	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	// MAPPINGS
	@GetMapping
	ModelAndView zoekHoogsteInRang() {
		return new ModelAndView(WERKNEMER_VIEW, "werknemer", werknemerService.zoekHoogsteInRang());
	}

	@GetMapping("{werknemer}")
	ModelAndView read(@PathVariable Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		if (werknemer != null) {
			modelAndView.addObject(werknemer);
		}
		return modelAndView;
	}

	 @GetMapping("/opslag/{werknemer}")
	 ModelAndView updateForm(@PathVariable Werknemer werknemer) {
	 if (werknemer == null) {
	 return new ModelAndView(WERKNEMER_VIEW);
	 }
	 return new ModelAndView(OPSLAG_VIEW)
			 .addObject("werknemer", werknemer)
			 .addObject(new OpslagForm());
	 }

}
