package SeleniumSessionAssingments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopup {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.popuptest.com/goodpopups.html");	
		
		driver.findElement(By.linkText("Good PopUp #3")).click();
		
		Set<String> handels = driver.getWindowHandles();
		
		Iterator<String> it = handels.iterator();
		 
		String parentWindowID = it.next();
		System.out.println("parent window id"+ parentWindowID);
		
		String childWindowID = it.next();
		System.out.println("child window id"+ childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		
		System.out.println("parent window title is:" + driver.getTitle());
		
		driver.quit(); 
		
	
	
	
	}

}
