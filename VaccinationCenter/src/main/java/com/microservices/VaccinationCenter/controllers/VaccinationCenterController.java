package com.microservices.VaccinationCenter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.microservices.VaccinationCenter.Model.Citizen;
import com.microservices.VaccinationCenter.Model.RequiredResponse;
import com.microservices.VaccinationCenter.Repos.CenterRepo;
import com.microservices.VaccinationCenter.service.VaccinationCenterService;



@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	
	@Autowired
	private VaccinationCenterService centerService;
	

	@PostMapping(path ="/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter vaccinationCenter){
		
		VaccinationCenter vaccinationCenterAdded = centerService.addCenter(vaccinationCenter);
		return new ResponseEntity<>(vaccinationCenterAdded, HttpStatus.OK);
		
		
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<RequiredResponse> getByCenterId(@PathVariable Integer id){
		RequiredResponse requiredResponse = centerService.getByCenterId(id);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	
	}
	
	

	
	
	

}
