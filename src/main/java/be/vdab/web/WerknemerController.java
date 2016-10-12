package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/werknemers")
public class WerknemerController {

	// VIEWS
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String REDIRECT_URL_WERKNEMER_NIET_GEVONDEN = "redirect:/werknemers";
	private static final String OPSLAG_VIEW = "werknemers/opslag";
	private static final String REDIRECT_NA_OPSLAG = "redirect:/werknemers/{werknemer}";

	private final WerknemerService werknemerService;

	// CONSTRUCTOR
	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}

	// DATABINDER
	@InitBinder("opslagForm")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	// MAPPINGS
	@GetMapping
	ModelAndView zoekHoogsteInRang() {
		return new ModelAndView(WERKNEMER_VIEW, "werknemer", werknemerService.zoekHoogsteInRang());
	}

	@GetMapping("{werknemer}")
	ModelAndView read(@PathVariable Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		if (werknemer == null) {
			return new ModelAndView(REDIRECT_URL_WERKNEMER_NIET_GEVONDEN);
		} else {
			modelAndView.addObject(werknemer);
		}
		return modelAndView;
	}

	// opslagformulier tonen
	@GetMapping("/opslag/{werknemer}")
	ModelAndView opslagForm(@PathVariable Werknemer werknemer) {
		if (werknemer == null) {
			return new ModelAndView(REDIRECT_URL_WERKNEMER_NIET_GEVONDEN);
		}
		return new ModelAndView(OPSLAG_VIEW).addObject("werknemer", werknemer).addObject(new OpslagForm());
	}

	// opslag verwerken
	@PostMapping("/opslag/{werknemer}")
	ModelAndView opslag(@PathVariable Werknemer werknemer, @Validated OpslagForm opslag, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(OPSLAG_VIEW);
		}
		werknemerService.opslag(werknemer, opslag.getBedrag());
		ModelAndView modelAndView = new ModelAndView(REDIRECT_NA_OPSLAG);
		modelAndView.addObject("bedrag", opslag.getBedrag());
		return modelAndView;
	}
}
