package com.booking.pages;

import org.openqa.selenium.By;

import com.booking.base.BasePage;
import com.booking.utilities.JavaScriptUtility;

public class SidePanel extends BasePage {

//	
	private By admin_button = By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']");


    
  public AdminPage clickAdminButton()  {
	JavaScriptUtility.clickJS(admin_button);
	return new AdminPage();
}
    
}
	
