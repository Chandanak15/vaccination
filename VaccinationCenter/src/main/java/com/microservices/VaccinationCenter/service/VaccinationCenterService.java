package com.microservices.VaccinationCenter.service;

import com.microservices.VaccinationCenter.Entity.VaccinationCenter;
import com.microservices.VaccinationCenter.Model.RequiredResponse;

public interface VaccinationCenterService {

	VaccinationCenter addCenter(VaccinationCenter vaccinationCenter);

	RequiredResponse getByCenterId(Integer id);

}
