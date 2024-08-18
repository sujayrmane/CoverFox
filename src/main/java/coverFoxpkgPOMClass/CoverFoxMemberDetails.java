package coverFoxpkgPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetails {


	@FindBy(xpath="//select[@id='Age-You']")private WebElement agedropdown;
	@FindBy(className ="next-btn") private WebElement nextbtn;
	
	public CoverFoxMemberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickonage(String age) {
		Reporter.log("age is selecting", true);
		Select s=new Select( agedropdown);

		s.selectByValue(age+"y");
		
	}
	public void nextbtn() {
		Reporter.log("clicking next", true);
		nextbtn.click();
	}
	
	
	
	
	
	
	
	
}
