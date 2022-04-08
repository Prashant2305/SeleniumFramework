package com.funtional.test;

import com.funtional.test.pages.PageObjectManager;

public class AppAutomationContextManager {
	public static PageObjectManager pageobjectmanager=null;

	public static PageObjectManager getPageobjectmanager() {
		return pageobjectmanager;
	}

	public static void setPageobjectmanager(PageObjectManager pageobjectmanager) {
		AppAutomationContextManager.pageobjectmanager = pageobjectmanager;
	}
	
}
