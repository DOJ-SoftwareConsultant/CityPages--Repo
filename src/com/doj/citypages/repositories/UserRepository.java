package com.doj.citypages.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doj.citypages.entities.CpuserAccount;


public interface UserRepository extends JpaRepository<CpuserAccount, Serializable> {
	public CpuserAccount findBycpemail(String email);
}
