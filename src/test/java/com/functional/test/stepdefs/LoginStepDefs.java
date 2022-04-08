package com.functional.test.stepdefs;

import com.funtional.test.AppAutomationContextManager;
import com.funtional.test.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	@Given("User is on Browser stack Home page")
	public void user_is_on_browser_stack_home_page() {
	  AppAutomationContextManager.getPageobjectmanager().getLoginPage().login();
	}

	@When("User click Pricing Menu")
	public void user_click_pricing_menu() {
	    
	}

	@When("choose valid plan based on requirement")
	public void choose_valid_plan_based_on_requirement() {
	   
	}

	@Then("User should be able to purchase valid plan")
	public void user_should_be_able_to_purchase_valid_plan() {
	    
	}

}
