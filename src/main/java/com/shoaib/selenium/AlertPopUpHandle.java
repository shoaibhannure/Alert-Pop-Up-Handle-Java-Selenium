package com.shoaib.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("//a[@title='Already a user? Sign in']")).click(); // Click Sign In Link
		System.out.println("Sign In Link clicked successfully");

		driver.findElement(By.xpath("//input[@value='Sign in']")).click();// Click Sign In button
		System.out.println("Sign In Button Clicked successfully");

		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());
		String text = alert.getText();

		if (text.equals("Please enter a valid user name")) {
			System.out.println("Correct Alert message is displayed");
		} else {
			System.out.println("Incorrect Alert message is displayed");
		}
		alert.accept(); // click OK button
		
		System.out.println("OK Button of Alert clicked successfully");
	}

}
