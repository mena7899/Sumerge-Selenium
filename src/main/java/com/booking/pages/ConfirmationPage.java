package com.booking.pages;

import org.openqa.selenium.By;

import com.booking.base.BasePage;

public class ConfirmationPage extends BasePage{
	
	private By box_hotle_name= By.cssSelector("div[data-capla-component-boundary*='b-checkout-bp-accommodation/PropertyDetails'] h1");
	
	public String getBoxHotleName() {
		
		return find(box_hotle_name).getText();
	}

}
