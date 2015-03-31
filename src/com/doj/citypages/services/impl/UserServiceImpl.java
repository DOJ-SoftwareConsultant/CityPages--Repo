package com.doj.citypages.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.entities.Roles;
import com.doj.citypages.entities.VerificationToken;
import com.doj.citypages.repositories.UserRepository;
import com.doj.citypages.repositories.VerificationTokenRepository;
import com.doj.citypages.services.IUserService;
import com.doj.citypages.services.UserDto;
import com.doj.citypages.validation.EmailExistsException;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	/*@Autowired
	private BCryptPasswordEncoder passwordEncoder;*/

	@Override
	public CpuserAccount registerNewUserAccount(UserDto accountDto)
			throws EmailExistsException {
		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException(
					"There is an account with that email adress: "
							+ accountDto.getEmail());
		}
		final CpuserAccount cpUser = new CpuserAccount();

		cpUser.setCpfname(accountDto.getFirstName());
		cpUser.setCplname(accountDto.getLastName());
		//cpUser.setCppwd(passwordEncoder.encode(accountDto.getPassword()));
		cpUser.setCppwd(accountDto.getPassword());
		cpUser.setCpemail(accountDto.getEmail());

		cpUser.setRole(new Roles(Integer.valueOf(1), cpUser));
		return userRepository.save(cpUser);
	}

	private boolean emailExist(String email) {
		CpuserAccount registeredUser = userRepository.findBycpemail(email);
		if (registeredUser != null) {
			return true;
		}
		return false;
	}

	@Override
	public CpuserAccount getUser(String verificationToken) {
		CpuserAccount CpRegistereduser = tokenRepository.findByToken(
				verificationToken).getCpuseraccount();
		return CpRegistereduser;
	}

	@Override
	    public void saveRegisteredUser(CpuserAccount CpuserAccount) {
		userRepository.save(CpuserAccount);
	    }

	@Override
	public void deleteUser(CpuserAccount user) {
		System.out.println(" not implemented this time");

	}

	@Override
	public void createVerificationTokenForUser(CpuserAccount cpuser, String token) {
		VerificationToken myToken = new VerificationToken(token, cpuser);
        tokenRepository.save(myToken);
	}

	@Override
	public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }

}