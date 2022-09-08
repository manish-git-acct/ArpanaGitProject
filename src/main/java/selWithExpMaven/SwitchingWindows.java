package selWithExpMaven;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {

	@Test
	public void switchWin()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\SeleniumTesting\\Sel@6.30PM(EST)\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWin=driver.getWindowHandles();
		System.out.println("total windows="+allWin.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWin.iterator();
		while(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window1="+win1);
		System.out.println("Window2="+win2);
		System.out.println("Window title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window title="+driver.getTitle());
		boolean LogEnabled=driver.findElement(By.id("w3loginbtn")).isEnabled();
		System.out.println(LogEnabled);
		if(LogEnabled==true)
		{
			System.out.println("Login button is enabled");
		}
		else
		{
			System.out.println("Login button is disabled");
		}
		driver.quit();
		
		
		
	}
}
