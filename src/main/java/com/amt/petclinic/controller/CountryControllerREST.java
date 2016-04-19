package com.amt.petclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amt.petclinic.domain.Feedback;
import com.amt.petclinic.service.FeedbackService;
import com.amt.petclinic.test.Country;

@RestController
public class CountryControllerREST {
	
	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/api/getAllCountries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();
		return listOfCountries;
	}
	
	@RequestMapping(value="/api/getAllComments", method=RequestMethod.GET, headers="Accept=application/json")
	public List<Feedback> getAllFeedbacks(){
		return feedbackService.findAll();
	}

	@RequestMapping(value = "/api/getCountries/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Country getCountryById(@PathVariable int id) {
		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries = createCountryList();
		for (Country country : listOfCountries) {
			if(country.getId()==id){
				return country;
			}
		}
		return null;
	}

	public List<Country> createCountryList() {
		Country nepal = new Country(1, "Nepal");
		Country china = new Country(2, "Bangladesh");
		Country pakistan = new Country(3, "Pakistan");
		Country bhutan = new Country(4, "Bhutan");
		Country srilanka = new Country(5, "Sri Lanka");

		List<Country> listOfCountries = new ArrayList<Country>();
		listOfCountries.add(nepal);
		listOfCountries.add(pakistan);
		listOfCountries.add(srilanka);
		listOfCountries.add(china);
		listOfCountries.add(bhutan);

		return listOfCountries;
	}
}
