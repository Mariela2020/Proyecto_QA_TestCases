package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    String baseUrl = "https://www.toctoc.com/";
    String expected = null;
    String actual = null;
    WebDriverWait wait;
    DesiredCapabilities capability= null;

    @BeforeTest
    @Parameters({"browser", "nodeUrl"})
    public void launchBrowser(String browser, String nodeUrl) throws Exception {
        switch (browser.toUpperCase()){
            case "CHROME":
                //System.out.println("chrome");
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.ANY);

                break;
            case "FIREFOX":
                System.out.println("firefox");
                // System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
                // driver =new FirefoxDriver();
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.ANY);

                break;
            case "EDGE":
                System.out.println("edge");
                capability = DesiredCapabilities.edge();
                capability.setBrowserName("MicrosoftEdge");
                capability.setPlatform(Platform.WINDOWS);
                // System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
                // driver = new EdgeDriver();
                break;
            case "OPERA":
                System.out.println("opera");
                System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
                driver = new OperaDriver();

                break;
            case "SAFARI":
                System.out.println("safari");
                capability = DesiredCapabilities.safari();
                capability.setBrowserName("safari");
                capability.setPlatform(Platform.IOS);
                break;
            default:
                Assert.fail("Verifique el browser seleccionado");

        }

        driver = new RemoteWebDriver(new URL(nodeUrl),capability);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1, enabled = true)
    public void register() throws InterruptedException {
        // expected = "TOCTOC.com:propiedades, casas y deptos. Asesórate antes de comprar";
        expected = "TOCTOC.com - Casas, Departamentos en Venta y Arriendo publicados en este portal inmobiliario";
        //Thread.sleep(2000);
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        driver.findElement(By.cssSelector("#onesignal-slidedown-cancel-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'btnLogin\']")).click();
        driver.findElement(By.id("IngresoUsuario.CorreoElectronico")).sendKeys("hurtadomariela2@gmail.com");
        driver.findElement(By.id("IngresoUsuario.Contrasena")).sendKeys("prueba");
        driver.findElement(By.xpath("/html/body/div[3]/section/div/div/div[3]/form/div[4]/button")).submit();
    }


}

