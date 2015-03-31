package com.doj.citypages.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the cpuseraccount database table.
 * 
 */
@Entity
@Table(name = "cpuseraccount")

public class CpuserAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int cpuid;

	@Column(length = 105)
	private String cpaddline1;

	@Column(length = 105)
	private String cpaddline2;

	private java.math.BigInteger cpcity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cpcreationtime;

	@Temporal(TemporalType.DATE)
	private Date cpdob;

	@Column(length = 100)
	private String cpemail;

	@Column(length = 75)
	private String cpfname;

	@Column(length = 45)
	private String cpgender;

	@Column(length = 45)
	private String cplname;

	private java.math.BigInteger cplocal;

	@Column(length = 80)
	private String cppwd;

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@OneToOne(mappedBy = "cpuseraccount", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Roles role;

	public CpuserAccount() {
	}
	

	public int getCpuid() {
		return this.cpuid;
	}

	public void setCpuid(int cpuid) {
		this.cpuid = cpuid;
	}

	public String getCpaddline1() {
		return this.cpaddline1;
	}

	public void setCpaddline1(String cpaddline1) {
		this.cpaddline1 = cpaddline1;
	}

	public String getCpaddline2() {
		return this.cpaddline2;
	}

	public void setCpaddline2(String cpaddline2) {
		this.cpaddline2 = cpaddline2;
	}

	public java.math.BigInteger getCpcity() {
		return this.cpcity;
	}

	public void setCpcity(java.math.BigInteger cpcity) {
		this.cpcity = cpcity;
	}

	public Date getCpcreationtime() {
		return this.cpcreationtime;
	}

	public void setCpcreationtime(Date cpcreationtime) {
		this.cpcreationtime = cpcreationtime;
	}

	public Date getCpdob() {
		return this.cpdob;
	}

	public void setCpdob(Date cpdob) {
		this.cpdob = cpdob;
	}

	public String getCpemail() {
		return this.cpemail;
	}

	public void setCpemail(String cpemail) {
		this.cpemail = cpemail;
	}

	public String getCpfname() {
		return this.cpfname;
	}

	public void setCpfname(String cpfname) {
		this.cpfname = cpfname;
	}

	public String getCpgender() {
		return this.cpgender;
	}

	public void setCpgender(String cpgender) {
		this.cpgender = cpgender;
	}

	public String getCplname() {
		return this.cplname;
	}

	public void setCplname(String cplname) {
		this.cplname = cplname;
	}

	public java.math.BigInteger getCplocal() {
		return this.cplocal;
	}

	public void setCplocal(java.math.BigInteger cplocal) {
		this.cplocal = cplocal;
	}

	public String getCppwd() {
		return this.cppwd;
	}

	public void setCppwd(String cppwd) {
		this.cppwd = cppwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpemail == null) ? 0 : cpemail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuserAccount other = (CpuserAccount) obj;
		if (cpemail == null) {
			if (other.cpemail != null)
				return false;
		} else if (!cpemail.equals(other.cpemail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cpuseraccount [cpuid=" + cpuid + ", cpaddline1=" + cpaddline1
				+ ", cpaddline2=" + cpaddline2 + ", cpcity=" + cpcity
				+ ", cpcreationtime=" + cpcreationtime + ", cpdob=" + cpdob
				+ ", cpemail=" + cpemail + ", cpfname=" + cpfname
				+ ", cpgender=" + cpgender + ", cplname=" + cplname
				+ ", cplocal=" + cplocal + ", cppwd=" + cppwd + "]";
	}

}