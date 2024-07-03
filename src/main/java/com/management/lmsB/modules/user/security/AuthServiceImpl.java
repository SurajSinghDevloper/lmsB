package com.management.lmsB.modules.user.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.lmsB.modules.admission.model.AdmissionRegistration;
import com.management.lmsB.modules.admission.repo.AddmissionRegistrationRepo;
import com.management.lmsB.modules.user.models.Role;
import com.management.lmsB.modules.user.models.Users;
import com.management.lmsB.modules.user.repositories.RoleRepository;
import com.management.lmsB.modules.user.repositories.UserRepository;
import com.management.lmsB.modules.user.security.UserRequestDTO;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private RoleRepository roleDao;
    
    @Autowired
    private AddmissionRegistrationRepo studentRepo;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public JwtAuthResponse login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);        
        JwtAuthResponse response = new JwtAuthResponse();
        String token = jwtTokenProvider.generateToken(authentication);
        
        if(loginDto.getLoginFor().equals("Adminstrative")) {	
        	Users user = userRepository.findByEmail(loginDto.getEmail());
        	response.setAccessToken(token);
            response.setUser(user);
        }
        if(loginDto.getLoginFor().equals("Student")) {
        	AdmissionRegistration user = studentRepo.findByEmail(loginDto.getEmail());
        	response.setAccessToken(token);
            response.setStudent(user);
        }
        

        return response;
    }
    
    

	@Override
	public String save(UserRequestDTO userRequestDto) throws Exception {
		Users user = new Users();
		if(userRequestDto.getEmail()==null || userRequestDto.getFirstName()==null || userRequestDto.getLastName()==null || userRequestDto.getPassword()==null 
				|| userRequestDto.getMobile()==null|| userRequestDto.getDob()==null)
		{
			throw new Exception("No_Records_Found");
		}
//		Optional<Role> role=roleDao.findRoleName(userRequestDto.getRole());
		
		Role setRole = roleDao.findByName("ROLE_USER");
		user.setFirstName(userRequestDto.getFirstName());
		user.setLastName(userRequestDto.getLastName());
		user.setEmail(userRequestDto.getEmail());
		user.setName(userRequestDto.getFirstName()+" "+userRequestDto.getLastName());
		user.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
		user.setMobile(userRequestDto.getMobile());
		user.setDob(userRequestDto.getDob());
		user.setAddress(userRequestDto.getAddress());
		user.setUsername(userRequestDto.getEmail());
		Set<Role> roles =new HashSet<>();
		roles.add(setRole);
		user.setRoles(roles);
		
		
		log.info("user ----- {}",user);
		
		
		userRepository.save(user);
		
		
		return "Resgister Successfull....";
	}
}
