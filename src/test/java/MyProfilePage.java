import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MyProfilePage extends BasePage{

    private By profileTitle = By.xpath("//h1");
    private By logoutInHoverList = By.xpath("//ul/li[a[@href='index.php?route=account/logout']]");
    private By loginButtonLocator = By.xpath("//div[@class='header-navbar-top-right-item header-navbar-top-right-login']");
    private By modifyProfileDetailsLocator = By.xpath("//ul/li/a[@href='https://shop.cafefrei.hu/index.php?route=account/edit']");
    private By successfulInfoUpdate = By.xpath("//div[@class='alert alert-success']");
    public MyProfilePage(WebDriver webDriver){
        super(webDriver);
    }

    public String getTitleText(){
        WebElement webElement = waitVisibiltyAndFindElement(profileTitle);
        return webElement.getText();
    }

    public LoginPage logOut(){

        WebElement logoutHref = waitVisibiltyAndFindElement(loginButtonLocator);

        Actions action = new Actions(driver);
        action.moveToElement(logoutHref).build().perform();

        sleep(1000); //animation - click delay
        WebElement logout = waitVisibiltyAndFindElement(logoutInHoverList);
        logout.click();

        return new LoginPage(driver);
    }

    public ProfileDetails enterProfileDetails(){
        WebElement profileDetails = waitVisibiltyAndFindElement(modifyProfileDetailsLocator);
        System.out.println(profileDetails.getText());
        profileDetails.click();
        return new ProfileDetails(driver);
    }

    public boolean getUpdateSuccess(){
        WebElement updateSuccess = waitVisibiltyAndFindElement(successfulInfoUpdate);
        return updateSuccess.getText().contains("Siker");
    }
}
