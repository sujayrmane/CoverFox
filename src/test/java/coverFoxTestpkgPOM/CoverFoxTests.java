package coverFoxTestpkgPOM;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBasePkgPOM.DriverBase;
import coverFoxUtilityPOM.UtilityCF;
import coverFoxpkgPOMClass.CoverFoxAddressDetails;
import coverFoxpkgPOMClass.CoverFoxHealthPlan;
import coverFoxpkgPOMClass.CoverFoxHomePage;
import coverFoxpkgPOMClass.CoverFoxMemberDetails;
import coverFoxpkgPOMClass.CoverFoxresultpage;


public class CoverFoxTests extends DriverBase{
	CoverFoxHomePage hpa;
	CoverFoxHealthPlan cfh;
	CoverFoxMemberDetails cfmd;
	CoverFoxAddressDetails cfad;
	CoverFoxresultpage cfrp;
	public static Logger logger;
	
  @BeforeTest
  public void Preconditions() {
	  logger=Logger.getLogger("CoverFoxInsurance");
	  PropertyConfigurator.configure("Log4j.properties");
	  
	  
	  DriverBase.LaunchBrowser();
	  logger.info("launching browser");


	  hpa=new CoverFoxHomePage(driver);
	  cfh=new CoverFoxHealthPlan(driver);
	  cfmd=new CoverFoxMemberDetails(driver);
	  cfad=new CoverFoxAddressDetails(driver);
	 cfrp =new CoverFoxresultpage(driver);
	  
	  
  }
  @BeforeClass
  public void browserOpen() throws InterruptedException {

  
	  hpa.clickmalebtn();
	  logger.info("clicking on male button");

	  Thread.sleep(1000);	
	  cfh.clickNext();
	  logger.info("clicking next button");
	  Thread.sleep(1000);	

	  cfmd.clickonage("28");
	  logger.warn("please enter valid age");

	  Thread.sleep(1000);	

	  cfmd.nextbtn();	
	  logger.info("clicking next button");
	  Thread.sleep(1000);	

	  cfad.enterpincode("431516");
	  logger.warn("please enter valid pincode");
	  Thread.sleep(1000);	
	  cfad.enternumber("9876543210");
	  logger.warn("enter valid mobile number");
	  Thread.sleep(1000);	

	  cfad.contBtn();
	  logger.info("clicking continue button");
	 
  }
	  
  @Test
  public void coverfoxResult() throws InterruptedException {
	  Thread.sleep(6000);
	  cfrp.Resultbanners();
	  cfrp.getPlanNumbersFromBanners();
	  Assert.assertEquals(cfrp.Resultbanners(),cfrp.getPlanNumbersFromBanners(),"banner is not equals to results,TC failed");
	  cfrp.sortdropdownisdiplayed();
	  Reporter.log("sort dopdown is displayed", true);
	  
  }
	  
  
  
  
 @AfterClass
 public void screenshot() throws IOException {
	 UtilityCF.Screenshot(driver);
 }
 
}
