package com.microservices.CitizenService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.CitizenService.Entity.Citizen;
import com.microservices.CitizenService.repositories.CitizenRepo;
import com.microservices.CitizenService.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	@Autowired
	private CitizenService citizenService;

	@RequestMapping(path = "/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {

		List<Citizen> listCitizen = citizenService.getById(id);
		return new ResponseEntity<List<Citizen>>(listCitizen, HttpStatus.OK);

	}

	@PostMapping(path = "/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {

		Citizen citizen = citizenService.addCitizen(newCitizen);
		return new ResponseEntity<Citizen>(citizen, HttpStatus.OK);

	}

}
