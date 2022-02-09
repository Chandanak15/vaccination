package com.microservices.VaccinationCenter.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.microservices.VaccinationCenter.Model.Citizen;
import com.microservices.VaccinationCenter.Model.RequiredResponse;
import com.microservices.VaccinationCenter.Repos.CenterRepo;
import com.microservices.VaccinationCenter.service.VaccinationCenterService;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{
	
	@Autowired
	private CenterRepo centerRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public VaccinationCenter addCenter(VaccinationCenter vaccinationCenter) {
		VaccinationCenter vaccinationCenterAdded = centerRepo.save(vaccinationCenter);
		return vaccinationCenterAdded;
	}

	@Override
	public RequiredResponse getByCenterId(Integer id) {
		RequiredResponse requiredResponse =  new RequiredResponse();
		VaccinationCenter center  = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);
		
		// then get all citizen registerd to vaccination center
		
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return requiredResponse;
	}

}
