package com.doj.citypages.events;

import java.util.Locale;


import org.springframework.context.ApplicationEvent;

import com.doj.citypages.entities.CpuserAccount;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private final String appUrl;
	private final Locale locale;
	private final CpuserAccount accountUser;

	public OnRegistrationCompleteEvent(CpuserAccount accountUser,
			Locale locale, String appUrl) {

		super(accountUser);
		this.accountUser = accountUser;
		this.locale = locale;
		this.appUrl = appUrl;

	}

	public String getAppUrl() {
		return appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public CpuserAccount getAccountUser() {
		return accountUser;
	}

}
