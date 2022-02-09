package com.microservices.CitizenService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.CitizenService.Entity.Citizen;
import com.microservices.CitizenService.repositories.CitizenRepo;
import com.microservices.CitizenService.service.CitizenService;

@Service
public class CitizenServiceImpl implements CitizenService{
	
	@Autowired
	private CitizenRepo repo;

	@Override
	public List<Citizen> getById(Integer id) {
		List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
		
		return listCitizen;
	}

	@Override
	public Citizen addCitizen(Citizen newCitizen) {
		Citizen citizen = repo.save(newCitizen);
		return citizen;
	}
	
	

}
