package com.funtional.test.pages;

import com.automation.context.AutomationContext;
import com.automation.ui.Browser;
import com.aventstack.extentreports.Status;

public class LoginPage {
	public void login() {
		Browser.launch(AutomationContext.getProp().getProperty("login.url"));
		AutomationContext.getExtenttestnode().log(Status.PASS, "Application launched successfully");
	}
}
