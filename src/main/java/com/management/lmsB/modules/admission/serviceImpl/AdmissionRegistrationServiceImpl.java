package com.management.lmsB.modules.admission.serviceImpl;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.lmsB.mailServices.RegistrationMails;
import com.management.lmsB.modules.admission.dtos.RegisterDTO;
import com.management.lmsB.modules.admission.model.AdmissionRegistration;
import com.management.lmsB.modules.admission.repo.AddmissionRegistrationRepo;
import com.management.lmsB.modules.admission.service.AdmissionRegistrationService;
import com.management.lmsB.modules.constants.Results;

@Service
public class AdmissionRegistrationServiceImpl implements AdmissionRegistrationService {

	@Autowired
	private AddmissionRegistrationRepo regRepo;
	@Autowired
	private RegistrationMails mailService;
	
	@Override
	public String newRegistration(RegisterDTO dto) {
		AdmissionRegistration newRegis = new AdmissionRegistration();
		newRegis.setName(dto.getName());
		newRegis.setEmail(dto.getEmail());
		newRegis.setMobile(dto.getMobile());
		newRegis.setPresentAdd(dto.getPresentAdd());
		newRegis.setAppliedFor(dto.getAppliedFor());
		AdmissionRegistration saved = regRepo.save(newRegis);
		String result =mailService.sendCompleteRegistrationEmail(saved.getEmail());
		return (saved!=null&& result.equals(Results.SUCCESS.toString())) ?Results.SUCCESS.toString():Results.FAILED.toString();
	}
}
