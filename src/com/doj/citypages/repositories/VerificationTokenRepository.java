package com.doj.citypages.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    
	public VerificationToken findByToken(String token);

    public VerificationToken findBycpuseraccount(CpuserAccount user);
}
