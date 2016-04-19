package com.amt.petclinic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amt.petclinic.domain.Feedback;
import com.amt.petclinic.service.FeedbackService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private FeedbackService feedbackService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	// public ModelAndView home(Locale locale, Model model) {
	public ModelAndView home(Locale locale) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		// model.addAttribute("serverTime", formattedDate);

		ModelAndView model = new ModelAndView();
		model.addObject("serverTime", formattedDate);
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("home");
		return model;

		// return "home";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET) public
	 * String loginPage(Model model) { return "login"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public String openAddMoviePage(Model model) {
		model.addAttribute("feedback", new Feedback());
		return "feedback";
	}

	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("feedback") Feedback feedback, BindingResult resultFeedback, ModelMap m) {
		feedbackService.create(feedback);
		return "redirect:/listFeedbacks";
	}

	@RequestMapping(value = "/listFeedbacks", method = RequestMethod.GET)
	public String listAllFeedbacks(Model model) {
		model.addAttribute("feedbacks", feedbackService.findAll());
		return "listFeedbacks";
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	/*
	 * @RequestMapping(value = "/dba**", method = RequestMethod.GET) public
	 * ModelAndView dbaPage() { ModelAndView model = new ModelAndView();
	 * model.addObject("title", "Spring Security Hello World");
	 * model.addObject("message", "This is protected page - Database Page!");
	 * model.setViewName("admin"); return model; }
	 */

	// for 403 access denied page
	/*
	 * @RequestMapping(value = "/403", method = RequestMethod.GET) public
	 * ModelAndView accesssDenied() {
	 * 
	 * ModelAndView model = new ModelAndView();
	 * 
	 * // check if user is login Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); if (!(auth
	 * instanceof AnonymousAuthenticationToken)) { UserDetails userDetail =
	 * (UserDetails) auth.getPrincipal(); model.addObject("username",
	 * userDetail.getUsername()); }
	 * 
	 * model.setViewName("403"); return model;
	 * 
	 * }
	 */
}
