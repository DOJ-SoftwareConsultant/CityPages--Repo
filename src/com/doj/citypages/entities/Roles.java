package com.doj.citypages.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(targetEntity = CpuserAccount.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cpuid")
	private CpuserAccount cpuseraccount;

	private Integer role;

	public Roles() {
		super();
	}

	public Roles(Integer role) {
		super();
		this.role = role;
	}

	public Roles(Integer role, CpuserAccount cpuseraccount) {
		super();
		this.role = role;
		this.cpuseraccount = cpuseraccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CpuserAccount getCpuseraccount() {
		return cpuseraccount;
	}

	public void setCpuseraccount(CpuserAccount cpuseraccount) {
		this.cpuseraccount = cpuseraccount;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Roles role = (Roles) obj;
		if (!role.equals(role.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Role [role=").append(role).append("]").append("[id=")
				.append(id).append("]");
		return builder.toString();
	}

}