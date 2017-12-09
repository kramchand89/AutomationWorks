package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.LiB;
import pompages.LoginPage;
@Test
public class TestInvalidLogin extends BaseTest {

	public void testInvalidLogin() {
	
	LoginPage l= new LoginPage(driver)
		
		// LoginPage l=new LoginPage(driver);
		int rowCount = LiB.getRowCount(Excel_Path, "InvalidLogin");
        for (int i = 1; i < rowCount; i++) {
			
        	
        	String username = LiB.getCellValue(Excel_Path, "InvalidLogin", i, 0);
        	String password = LiB.getCellValue(Excel_Path, "InvalidLogin", i, 1);
               	
        	
		}
		
		
	}
	
	
}
