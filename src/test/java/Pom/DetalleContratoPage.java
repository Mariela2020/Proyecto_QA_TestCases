package Pom;

import Utils.LogHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleContratoPage extends BasePage{

    private static final Logger LOGGER = LogHelper.getLogger(DetalleContratoPage.class);

    public DetalleContratoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[4]/section/div/div[1]/h3[1]")
    private org.openqa.selenium.WebElement titledetalleContrato;
    private String titlePage26 = "TOCTOC.com Gestión Corredoras";


    //@FindBy (xpath = "//*[@id='app']/div/div[4]/section/div/div[3]/div[2]/table/tr[9]/td")
    @FindBy (xpath = "/html/body/div/div/div[4]/section/div/div[3]/div[2]/table/tr[8]/td")
    //@FindBy (css = "#app > div > div.pago__Productos__Extra__detalle.contenedor-padre > section > div > div:nth-child(3) > div:nth-child(2) > table > tr:nth-child(7) > td")
    private WebElement resultotaltext;

    @FindBy (xpath ="/html/body/div/div/div[4]/section/div/div[4]/div/a")
    //@FindBy (className = "btnPagar")
    private WebElement btnPagar;

    @FindBy (xpath ="/html/body/div/div/div/div/div/div[2]/div[2]/h1")
    private WebElement titledetallepago;

    public boolean istitledetalleDisplayed() throws Exception {
        Thread.sleep(2000);
        return this.isDisplayed(titledetalleContrato) && this.getTitle().equals(titlePage26);
    }

    public void WriteExcelFile() throws Exception {
        String filepath = "src/test/resources/filepath/Test.xlsx";
        String date = getDate();
        String resultText= getText(resultotaltext);
        LOGGER.log(Level.INFO, "El valor total del Producto es:" + resultText);
        readExcel(filepath, "Hoja1");
        writeExcel(filepath,"Hoja1", resultText + " " + date);
        readExcel(filepath,"Hoja1");
    }

    public void ClickOnbtnPagar() throws Exception {
        //Thread.sleep(2000);
        this.click(btnPagar);
    }

    public boolean istitledetalleDisplayed2() throws Exception {
        Thread.sleep(2000);
        return this.isDisplayed(titledetallepago);
   }
}
