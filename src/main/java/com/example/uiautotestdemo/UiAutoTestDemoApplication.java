package com.example.uiautotestdemo;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UiAutoTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiAutoTestDemoApplication.class, args);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://www.baidu.com");
		Dimension dimension = new Dimension(1200, 800);
		webDriver.manage().window().setSize(dimension);
		String searchKey = "测试";
		try {
			Thread.sleep(1000);
//			System.out.println("The testing page title is: " + webDriver.getTitle());
			Thread.sleep(1000);
			webDriver.findElement(By.id("kw")).sendKeys("测试");
			Thread.sleep(1000);
			webDriver.findElement(By.id("su")).click();
			Thread.sleep(2000);
			WebElement result = webDriver.findElement(By.className("result"));
			List<WebElement> result1 = webDriver.findElements(By.className("result"));
//			for (WebElement webElement : result1) {
//				System.out.println(webElement.getText());
//				System.out.println("-------------------------------------------------------");
//			}
			System.out.print("搜索结果第一条是否包含关键词 ( ' "+ searchKey +" ' ) ：");
			if (result.getText().contains(searchKey)){
				System.out.print("√");
			}else{
				System.out.print("X");
			}
			System.out.println();
			System.out.println("================================");
			System.out.println("搜索结果第一条数据：" + result.getText());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriver.quit();
	}

}
