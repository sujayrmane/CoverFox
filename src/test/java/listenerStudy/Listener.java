package listenerStudy;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBasePkgPOM.DriverBase;
import coverFoxUtilityPOM.UtilityCF;

public class Listener extends DriverBase  implements ITestListener {
	
@Override
public void onTestStart(ITestResult result) {
	Reporter.log("TC"+result.getName()+" execution started", true);
}

@Override
	public void onTestFailure(ITestResult result) {
//	try {
//		UtilityCF.Screenshot(driver);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

Reporter.log("TC"+result.getName()+" failed", true);
	}

@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC"+result.getName()+"successfully executed", false);
	}

}
