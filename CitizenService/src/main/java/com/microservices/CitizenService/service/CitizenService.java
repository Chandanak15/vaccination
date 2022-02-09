package com.microservices.CitizenService.service;

import java.util.List;

import com.microservices.CitizenService.Entity.Citizen;

public interface CitizenService {

	List<Citizen> getById(Integer id);

	Citizen addCitizen(Citizen newCitizen);

}
