package com.booking.pages;



import org.openqa.selenium.By;

import com.booking.base.BasePage;
import com.booking.utilities.DropDownUtility;
import com.booking.utilities.JavaScriptUtility;

public class DetailsPage extends BasePage {
	
	private By queen_bed_button = By.cssSelector("div[class='hprt-roomtype-bed'] input[value='2']");
	private By amount_drop_down_list= By.cssSelector("select[class='hprt-nos-select js-hprt-nos-select']");
	private By reserve_button=By.xpath("//span[contains(@class, 'js-reservation-button__text')]");
	private By checkin_date = By.cssSelector("button[data-testid='date-display-field-start'] > *:nth-child(1)");
	private By checkout_date = By.cssSelector("button[data-testid='date-display-field-end'] > *:nth-child(1)");
	public void clickQueenBedButton() {
		
		JavaScriptUtility.clickJS(queen_bed_button);

	}

	public void selectAmountByOrder(int order) {
		
		DropDownUtility.selectByIndex(amount_drop_down_list, order);

	}
	public String getCheckinDate() {
		return find(checkin_date).getText();
	}
	
	public String getCheckoutDate() {
		return find(checkout_date).getText();
	}
	
	public ConfirmationPage clickReseveButton() {
		JavaScriptUtility.clickJS(reserve_button);
		
		return new ConfirmationPage();
	}
}
