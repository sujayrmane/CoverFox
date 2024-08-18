package coverFoxpkgPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlan {

	
	@FindBy(xpath="//div[@class='next-btn']")private WebElement Next;
	
	

	public	CoverFoxHealthPlan(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickNext() {
		Reporter.log("clicking next button", true);
		Next.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
