package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

    public WebDriver initialize_driver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

     /*   switch (initialize_driver()){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver= new ChromeDriver();
                break;

            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver =new FirefoxDriver();
                break;

            case "EDGE":
                System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                break;

            case "OPERA":
                System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
                driver = new OperaDriver();
                break;

            default:
                Assert.fail("Verifique el browser seleccionado");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);
    } */

}
