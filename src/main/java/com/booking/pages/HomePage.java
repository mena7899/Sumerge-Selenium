package com.booking.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import com.booking.base.BasePage;
import com.booking.pages.windows.DateRangeWindow;
import com.booking.utilities.JavaScriptUtility;

public class HomePage extends BasePage {
	
	private By search_location_input = By.cssSelector("input[name='ss']");
	private By dates_window_button = By.cssSelector("button[data-testid='searchbox-dates-container']");
	private  By search_button = By.cssSelector("button[type='submit']");
	private By tolip_see_availability_button = By.cssSelector("a[data-testid='availability-cta-btn'][href*='https://www.booking.com/hotel/eg/royal-tulip-alexandria']");
	
	public void setLocation(String location) {
		set(search_location_input, location);
		//JavaScriptUtility.setJS(search_location_input, location);
	}
	
	public DateRangeWindow openDatesWindow() {
		JavaScriptUtility.clickJS(dates_window_button);
		return new  DateRangeWindow();
		
	}
	
	public void clickSearchButton() {
		JavaScriptUtility.clickJS(search_button);
	}

		///////////////////////////////////////////////////

	public DetailsPage clickTolipSeeAvailabilityButton() {
		
		JavaScriptUtility.clickJS(tolip_see_availability_button);
		Set<String> allTabs = driver.getWindowHandles();
		List<String> tabList = new ArrayList<>(allTabs);
		driver.switchTo().window(tabList.get(tabList.size() - 1));
		return new DetailsPage();
	}
		public void reloadHomePage() {
			
			reloadPage();
		}
}
		//////////////////////////////////////////////////////////////////////

		