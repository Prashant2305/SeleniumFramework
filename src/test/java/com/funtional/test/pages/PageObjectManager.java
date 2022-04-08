package com.funtional.test.pages;

public class PageObjectManager {
	private LoginPage loginPage;
	
	public LoginPage getLoginPage(){

		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;

	}

}
