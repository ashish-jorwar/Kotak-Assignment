package POM;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class KotakCherry {
	WebDriver driver;
	@FindBy(xpath ="(//*[@class='ieco-tab-text ieco-pos-fixed swiper-slide ng-star-inserted'])[3]" ) public WebElement deposit;
	@FindBy(xpath = "(//*[@class='ieco-title-stock ieco-left ieco-seo'])[1]") public WebElement Fixed;

	public void page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deposits() {
		deposit.click();
	}
	

	public void fixedDeposit() {
		Fixed.click();
	
	}
}
