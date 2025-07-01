package pract;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class pract {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//locators:tag, id, classname, xpath, css,link text,  partial link text , text
		
		//select the radio button
		
		String s = driver.getTitle();
		System.out.println("Title of the page :"+s);
		
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		
		radio1.click();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File("screenshots/example_homepage.png");
		FileUtils.copyFile(screenshot, destination);
		
		if (radio1.isSelected()) {
            System.out.println("Checkbox is checked ✅");
        } else {
            System.out.println("Checkbox is NOT checked ❌");
        }
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		
		
		
		Thread.sleep(3000);
		
		WebElement suggestionbox = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
		
		suggestionbox.sendKeys("india");
		
		List<WebElement> allelem = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		
		
		for(WebElement suggestion :allelem ) {
			String value= suggestion.getText();
			System.out.println(value);
			if(value.equalsIgnoreCase("india")) {
				suggestion.click();
				((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
				File destination1 = new File("screenshots/suggestion.png");
				FileUtils.copyFile(screenshot, destination1);
				
				break;
				
			}
		}
		
			
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select sc = new Select(dropdown);
		sc.selectByValue("option3");
		
		//checkthecheckbox
		
		WebElement checkbx = driver.findElement(By.xpath("//input[@name='checkBoxOption2']"));
		
		checkbx.click();
		
		
		
				
		
		//driver.quit();
		

	}

	

}
