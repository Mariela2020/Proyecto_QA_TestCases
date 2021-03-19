package TestCases;

import Pom.*;
import io.qameta.allure.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({AllureListener.class})
public class LoginTest extends BaseClass {

    public WebDriver driver;

    //String baseUrl = "https://www.toctoc.com/";
    String expected = null;
    String actual = null;
    WebDriverWait waitElement;
    LoginPageHome loginPageHome;

    @BeforeClass
    public void setup(){
        BaseClass baseClass= new BaseClass();
        driver = baseClass.initialize_driver();
        driver.get("https://www.toctoc.com/");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Verifica Titulo Home Page")
    @Description("Verifica Titulo Home Page")
    @Epic("EP001")
    @Feature("Feature 1: Titulo")
    @Story("Story: Titulo Presente")
    @Step("Verifica Titulo Home Page")
    public void mensajeprensence() throws InterruptedException {
        // expected = "TOCTOC.com:propiedades, casas y deptos. Asesórate antes de comprar";
        loginPageHome = new LoginPageHome(driver);
        expected = "TOCTOC.com - Casas, Departamentos en Venta y Arriendo publicados en este portal inmobiliario";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
        loginPageHome.CloseMens();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2, description = "Verifica el login")
    @Description("Verifica login con Credenciales Validas")
    @Epic("EP001")
    @Feature("Feature2: Login")
    @Story("Story:Valida Login")
    @Step("Verifica Credenciales")

    public void loginTest() throws Exception {
        loginPageHome.ClickEntrarLink();
        loginPageHome.EnterLogin("hurtadomariela2@gmail.com", "prueba");
        loginPageHome.ClickIniciarBtn();

    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3, description = "Verifica usuario Registrado")
    @Description("Verifica Usuario Registrado")
    @Epic("EP001")
    @Feature("Feature 3: Usuario Registrado")
    @Story("Story: Usuario Registrado")
    @Step("Usuario Registrado")
    public void registrationTest() throws Exception {
        //throw new SkipException("Skipping this test");
        loginPageHome.registroPageIsDisplayed();

    }


}

