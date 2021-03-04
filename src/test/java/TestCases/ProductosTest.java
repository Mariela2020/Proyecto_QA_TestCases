package TestCases;

import Pom.*;
import Runners.DriverManagerFactory;
import Runners.DriverType;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ProductosTest {

    static WebDriver driver;
    String baseUrl = "https://ww2.toctoc.com/gestioncorredor/";
    String expected = null;
    String actual = null;
    WebDriverWait waitElement;
    DesiredCapabilities capability= null;
    HomePageCorredor homePageCorredor;
    ProductosPage productosPage;
    LoginPageCorredor loginPageCorredor;
    DatosContratosPage datosContratosPage;
    DetalleContratoPage detalleContratoPage;

    @BeforeTest
    //@Parameters({"browser"})
    public void setUpTest() throws MalformedURLException {
        DriverManagerFactory.getInstance().setDriver(DriverType.CHROME);
        driver = DriverManagerFactory.getInstance().getDriver();
        driver.get(baseUrl);
        waitElement = new WebDriverWait(driver, 15);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

   @Test
    public void Producto() throws Exception {
       homePageCorredor = new HomePageCorredor(driver);
       productosPage = new ProductosPage(driver);
       loginPageCorredor = new LoginPageCorredor(driver);
       datosContratosPage= new DatosContratosPage(driver);
       detalleContratoPage= new DetalleContratoPage(driver);
       Assert.assertTrue(homePageCorredor.homePageIsDisplayed());
       homePageCorredor.clickOnProductos();
       Assert.assertTrue("No se redirrecciono correctamente a la pagina de Productos", productosPage.isImagenDisplayed());
       productosPage.clickOnTarjetaProducto();
       Assert.assertTrue(productosPage.isImagenDisplayed2());
       productosPage.ClickOnComprar();
       loginPageCorredor.isImagenDisplayed3();
       Thread.sleep(1000);
       loginPageCorredor.typeEmailLocator();
       loginPageCorredor.typePasswordLocator();
       loginPageCorredor.ClickOnIngresar();
       Assert.assertTrue(datosContratosPage.isImagenDisplayed4());
       datosContratosPage.typeDatosContratospaso1();
       Assert.assertTrue(datosContratosPage.isImagenDisplayed5());
       datosContratosPage.typeDatosContratospaso2();
       Assert.assertEquals(datosContratosPage.selectDropdownList(), "Metropolitana");
       Assert.assertEquals(datosContratosPage.selectDropdownList1(), "Santiago");
       datosContratosPage.ClickOncheckaceptaTerminos();
       //datosContratosPage.ClickOncheckactulizainfo();
       datosContratosPage.ClickOnbtnContinuar();
       Assert.assertTrue(detalleContratoPage.istitledetalleDisplayed());
       detalleContratoPage.WriteExcelFile();
       detalleContratoPage.ClickOnbtnPagar();
       Assert.assertTrue(detalleContratoPage.istitledetalleDisplayed2());
   }





}
