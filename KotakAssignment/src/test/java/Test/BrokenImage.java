
package Test;



import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import POJO.Browser;


public class BrokenImage extends Browser {
	
	WebDriver driver  ;
	
	@Test
	public void test() throws InterruptedException, ProtocolException, IOException {
		driver =Browser.OpenBrowser("https://www.kotakcherry.com/deposits");
		
		Thread.sleep(5000);
		List <WebElement> images = driver.findElements(By.tagName("img"));
		
		System.out.println("total no. of images in the webpage " +images.size());
       int k=0;
		for(WebElement image:images) {
			//if(image != null) {
				
				String imagesrc = image.getAttribute("src");
				URL url=new URL(imagesrc);
				URLConnection urlconnection = url.openConnection();
				HttpURLConnection httpURLconnection = (HttpURLConnection)urlconnection;
				httpURLconnection.setConnectTimeout(2000);
				httpURLconnection.connect();
				
				if(httpURLconnection.getResponseCode()!=200)
				{
					System.out.println("Image is broken:"+imagesrc);
					
				k++;
				
				}
				
			}
		System.out.println(k);
		}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{

	if(ITestResult.FAILURE == result.getStatus())
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String name = result.getName();
			FileUtils.copyFile(source,new File("C:\\Users\\admin\\Desktop\\Screenshot of Kotak Bank\\" + name + ".jpg"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	driver.quit();
	}
}





