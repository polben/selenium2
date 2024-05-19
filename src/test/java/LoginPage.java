import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private By emailField = By.xpath("//input[@name='email']");
    private By passField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@class='button btn btn-lg btn-xl btn-primary']");
    private By loginTitle = By.xpath("//h1[@class='page-head-center-title']");

    private String emailstr = "polgarbence0710@gmail.com";
    private String passwstr = "jelszo1234";
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public MyProfilePage sendCredentials(){
        WebElement email = waitVisibiltyAndFindElement(emailField);
        email.sendKeys(emailstr);

        WebElement pass = waitVisibiltyAndFindElement(passField);
        pass.sendKeys(passwstr);

        WebElement loginButtonElem = waitVisibiltyAndFindElement(loginButton);
        loginButtonElem.click();

        return new MyProfilePage(driver);
    }

    public String getTitleText(){
        WebElement webElement = waitVisibiltyAndFindElement(loginTitle);
        return webElement.getText();
    }

}
