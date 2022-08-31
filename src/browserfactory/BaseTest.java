package browserfactory;
/*Project-3 - ProjectName : com-herokuapp-sw-2 BaseUrl = http://the-internet.herokuapp.com/login
 1. Create the package ‘browserfactory’ and create the class with the name ‘BaseTest’ inside the ‘browserfactory’ package.
  And write the browser setup code inside the class ‘Base Test’. */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser (String baseUrl){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closebrowser (){
        driver.quit();
    }
}
