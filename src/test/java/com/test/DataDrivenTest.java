package com.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.TestUtil;

public class DataDrivenTest {

	public static WebDriver driver;
	public int rowCount;
	public String FirstName;
	public String LastName;
	public String Email_Address;
	public String Password;
	public ArrayList<Object[]> testdata;


	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/hcl/Mathesh - NBA/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://reg.ebay.in/reg/PartialReg");
	}

	@DataProvider
	public Iterator<Object[]> getdata()
	{
		testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();

	}

	@Test(dataProvider="getdata")
	public void getExcelData(String FirstName, String LastName, String Email_Address, String Password)
	{

		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(FirstName);

		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(LastName);

		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email_Address);

		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(Password);

	}

	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		System.out.println("Program completed");
	}

}
