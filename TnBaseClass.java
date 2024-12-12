package com.Open_Mrc;


	import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File; 
	import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class TnBaseClass {
		
 		public static WebDriver driver;
 		
 		public static ExtentReports extentReports;
 		public static File file;
		private static WebElement element;
		
		protected static WebDriver BrowserLaunch (String browserName) {
			 
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				
			}else if(browserName.equalsIgnoreCase("edge")){
				driver = new EdgeDriver();
				
			}else if(browserName.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
			 driver.manage().window().maximize(); 
			return driver;
			
			
		}
		
		
        public static void extentReportStart(String location) {
			
			extentReports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));	

		}

          public  static void extentReportTearDown(String location) throws IOException {
	        extentReports.flush();
	         file = new File(location);
	         Desktop.getDesktop().browse((file).toURI());
        }
          
          public String takeScreenshot() throws IOException {
  			TakesScreenshot screenshot = (TakesScreenshot) driver;
  			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
  			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
  			File destfile = new File("Screenshorts\\.png" + "_" + timeStamp + ".png");
  			FileUtils.copyFile(scrfile, destfile);
  			return destfile.getAbsolutePath();
  		}
		

		protected static void RobotActions(String key) {
			try {
				Robot RA = new Robot();
				if(key.equalsIgnoreCase("Enter")) {
					RA.keyPress(KeyEvent.VK_ENTER);
				}else if(key.equalsIgnoreCase("Backspace")) {
					RA.keyPress(KeyEvent.VK_BACK_SPACE);
				}else if(key.equalsIgnoreCase("Tab")) {
					RA.keyPress(KeyEvent.VK_TAB);
				}
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print("Erorr in the robot Action");
			}
		}
		
		protected static void Alert(WebDriver driver, String pop, String confirmtype, String inputValue) {
			element.click();
		}
		
		protected static void javascriptexcutor(WebElement Name) {
			JavascriptExecutor jsc = (JavascriptExecutor) driver;
			jsc.executeScript("arguments[0].scrollInroView();",Name);
		}
		
		
		protected static void takeScreenShot() {
			TakesScreenshot HV =(TakesScreenshot) driver;
			File source =HV.getScreenshotAs(OutputType.FILE);
			File Desdination = new File("C:\\Users\\Hp\\OneDrive\\Documents\\gk_java\\Selenum_Java\\Image\\insta.png");
			try {
				FileHandler.copy(source, Desdination);
			}catch(IOException HV1){
			   HV1.printStackTrace();
			   System.err.print("ERROR IN SCREENSHOT");
			}
		}
		
		protected static void mouseAction(WebDriver driver, WebElement element, String typeActions) {
			Actions ac = new Actions(driver);
			if(typeActions.equalsIgnoreCase("Click")) {
				ac.click(element).build().perform();
			}else if(typeActions.equalsIgnoreCase("doubleclick")) {
				ac.contextClick(element).build().perform();
			}
		}
		
		protected static void launchUrl(String UrlLink) {
			
				driver.get(UrlLink);
		}
		
		protected static void DropDown (WebElement element, String selectionType, String selectionValue) {
		try {
			Select dropdown = new Select(element);
			if(selectionType.equalsIgnoreCase("text")) {
				dropdown.selectByVisibleText(selectionValue);
				}else if (selectionType.equalsIgnoreCase("Value")) {
					dropdown.selectByValue(selectionValue);
				}
				}	catch(NumberFormatException h) {
					   h.printStackTrace();
					   System.out.print("Error in selectiondorpdwon");
				}
			
		}
		
			protected static void ScrollUPDown() {
				JavascriptExecutor sc = (JavascriptExecutor) driver;
				sc.executeScript("window.scrollBy(0,4000);");
				sc.executeScript("window.scrollBy(0,-3000);");

			}
			
			protected static void get(WebDriver driver, String Webpage, WebElement element) {
				if(Webpage.equalsIgnoreCase("getTitle")) {
					String title = driver.getTitle();
					System.out.print("The Title of the page: "+title);
				}else if (Webpage.equalsIgnoreCase("GetCurrentUrl")) {
					String currentUrl = driver.getCurrentUrl();
					System.out.print("get Current Url of the page:"+currentUrl);
				}
			}
			
			protected static void isEnable(WebElement element) {
				System.out.print("element.isEnable()");
			}
			 
			protected static void isDisplay(WebElement element) {
				System.out.print("element.isDispaly()");
			}
			
			protected static void isSelected(WebElement element) {
				System.out.print("element.isSelected()");
			}
				
			    protected static void Text(WebElement element) {
				  System.out.print(element.getText());  
				}
				
				protected static void Navigateto(String url) {
					driver.navigate().to(url);
				}
				protected static void nRefresh() {
					driver.navigate().refresh();
					
				}
				protected static void Nback() {
					driver.navigate().back();
				}
				
				protected void QuitBrowser() {
					driver.quit();
				}
				protected static void closeBrowser() {
					driver.close();
				}
				
				
					// TODO Auto-generated method stub
					
				

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}
	}
	