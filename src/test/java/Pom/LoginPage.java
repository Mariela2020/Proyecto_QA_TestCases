package Pom;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    //public LoginPage(WebDriver driver) {
    //        PageFactory.initElements(driver, this);
    //    }

    @FindBy(css = "#onesignal-slidedown-cancel-button")
    private WebElement txtmensaje;

    //@FindBy(id = "btnLogin")
    @FindBy(xpath = "//*[@id=\'btnLogin\']")
    private WebElement btnentrar;

    @FindBy(id = "IngresoUsuario.CorreoElectronico")
    private WebElement txtemailusuario;

    @FindBy(id = "IngresoUsuario.Contrasena")
    private WebElement txtpassword;

    @FindBy(xpath = "/html/body/div[3]/section/div/div/div[3]/form/div[4]/button")
    private WebElement btniniciar;

    public void ClickEntrarLink() {
        txtmensaje.click();
        btnentrar.click();
    }

    public void EnterLogin(String userName, String password) {
        txtemailusuario.sendKeys(userName);
        txtpassword.sendKeys(password);
    }

    public void ClickIniciarBtn() {
        btniniciar.submit();
    }




}