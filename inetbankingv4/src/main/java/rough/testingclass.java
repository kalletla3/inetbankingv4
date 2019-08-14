package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testingclass{

	public static WebDriver driver;
	public WebElement dob = driver.findElement(By.xpath("//input[@name='bdaytime']"));
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nihauttam\\Desktop\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/");
		testingclass ts = new testingclass();
		ts.bdayTime("1986", "10", "10", "04", "30");
	}


		public void bdayTime(String yy, String mm, String dd, String hh, String MM) {
			dob.sendKeys(yy);
			dob.sendKeys(mm);
			dob.sendKeys(dd);
			dob.sendKeys(hh);
			dob.sendKeys(MM);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
		}

}	

