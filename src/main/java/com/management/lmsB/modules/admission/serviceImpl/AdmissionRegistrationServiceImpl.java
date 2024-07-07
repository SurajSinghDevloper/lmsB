package com.management.lmsB.modules.admission.serviceImpl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.lmsB.mailServices.RegistrationMails;
import com.management.lmsB.modules.admission.dtos.RegisterDTO;
import com.management.lmsB.modules.admission.model.AdmissionRegistration;
import com.management.lmsB.modules.admission.repo.AddmissionRegistrationRepo;
import com.management.lmsB.modules.admission.service.AdmissionRegistrationService;
import com.management.lmsB.modules.constants.Results;
import com.management.lmsB.modules.constants.UserTypes;
import com.management.lmsB.modules.user.models.Role;
import com.management.lmsB.modules.user.models.Users;
import com.management.lmsB.modules.user.repositories.RoleRepository;
import com.management.lmsB.modules.user.repositories.UserRepository;
import com.management.lmsB.utils.PasswordGenerator;

@Service
public class AdmissionRegistrationServiceImpl implements AdmissionRegistrationService {

	@Autowired
	private AddmissionRegistrationRepo regRepo;
	@Autowired
	private RegistrationMails mailService;
	@Autowired
	private RoleRepository roleDao;
	@Autowired
	private PasswordGenerator pass;
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String newRegistration(RegisterDTO dto) {
		AdmissionRegistration found =regRepo.findByEmail(dto.getEmail());
		String result="";
		AdmissionRegistration saved=null;
		if(found==null) {
			AdmissionRegistration newRegis = new AdmissionRegistration();
			String userPassword = pass.generateUniquePassword();
			newRegis.setName(dto.getName());
			newRegis.setEmail(dto.getEmail());
			newRegis.setMobile(dto.getMobile());
			newRegis.setPresentAdd(dto.getPresentAdd());
			newRegis.setAppliedFor(dto.getAppliedFor());
			newRegis.setPassword(userPassword);
			 saved = regRepo.save(newRegis);
			if(saved!=null) {
				Users newUser = new Users();
				Role setRole = roleDao.findByName("ROLE_STUDENT");
				newUser.setName(saved.getName());
				newUser.setEmail(saved.getEmail());
				newUser.setUsername(saved.getEmail());
				newUser.setUserType(UserTypes.UNVERIFIED_STUDENT);
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				newUser.setPassword(bCryptPasswordEncoder.encode(saved.getPassword()));
				newUser.setMobile(saved.getMobile());
				newUser.setAddress(saved.getPresentAdd());
				Set<Role> roles =new HashSet<>();
				roles.add(setRole);
				newUser.setRoles(roles);
				userRepo.save(newUser);
			}
			 result =mailService.sendCompleteRegistrationEmail(saved.getEmail(),saved.getPassword());
			 return (saved!=null&& result.equals(Results.SUCCESS.toString())) ?Results.SUCCESS.toString():Results.FAILED.toString();
		}
		return Results.ALLREADY_EXIST.toString();
	}
}
