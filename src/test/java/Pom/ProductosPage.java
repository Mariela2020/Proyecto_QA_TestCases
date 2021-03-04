package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductosPage extends BasePage {

    @FindBy(xpath="//*[@id=\"app\"]/div/div[3]/section[2]/a/div/h2")
    private WebElement imagenlocator;
    private String titlePage = "TOCTOC.com - Productos y servicios para Corredores de propiedades";

    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[1]/div[2]/h4")
    private WebElement imagentarjeta;

    @FindBy (xpath="//*[@id=\"vitrina_productos\"]/div/button[1]/div[2]/h4")
    private WebElement productolocator;

    // @FindBy(linkText = "COMPRAR")
    @FindBy (css = "body > div.fade.modal.show > div > div > div.modal-footer > div:nth-child(2) > a")
    private WebElement btncomprar;

    public ProductosPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean isImagenDisplayed() throws Exception {
        Thread.sleep(1000);
        return this.isDisplayed(imagenlocator) && this.getTitle().equals(titlePage);
    }

    public void clickOnTarjetaProducto() throws Exception {
        Thread.sleep(2000);
        this.click(imagentarjeta);
    }

    public boolean isImagenDisplayed2() throws Exception {
        return this.isDisplayed(productolocator) && this.getTitle().equals(titlePage);
    }

    public void ClickOnComprar() throws Exception {
        Thread.sleep(1000);
        this.click(btncomprar);
    }


}

