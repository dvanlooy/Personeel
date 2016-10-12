package be.vdab.web;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Jobtitel;
import be.vdab.services.JobtitelService;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping("/jobtitels")
public class JobtitelController {
	private static final String JOBTITEL_VIEW = "jobtitels/jobtitels";

	private final JobtitelService jobtitelService;
	private final WerknemerService werknemerService;
	

	// CONSTRUCTOR
	JobtitelController(JobtitelService jobtitelService, WerknemerService werknemerService) {
		this.jobtitelService = jobtitelService;
		this.werknemerService = werknemerService;
	}

	// MAPPINGS
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(JOBTITEL_VIEW, "jobtitels", jobtitelService.findAll());
	}
	
	@GetMapping("{jobtitel}")
	ModelAndView read(@PathVariable Jobtitel jobtitel, Pageable pageable) {
		ModelAndView modelAndView = new ModelAndView(JOBTITEL_VIEW);
		modelAndView.addObject("jobtitels", jobtitelService.findAll());
		if (jobtitel != null) {
		
			modelAndView.addObject(jobtitel);
			modelAndView.addObject("page", werknemerService.findByJobtitel(jobtitel, pageable));
			return modelAndView;
		}
		return modelAndView;
	}

}
