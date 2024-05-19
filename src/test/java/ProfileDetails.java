import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ProfileDetails extends BasePage{
    private By faxFieldLocator = By.xpath("//input[@name='fax']");
    private By submitProfileData = By.xpath("//button[@type='submit']");
    public ProfileDetails(WebDriver webDriver){
        super(webDriver);
    }

    public MyProfilePage setFaxData(){
        WebElement faxField = waitVisibiltyAndFindElement(faxFieldLocator);

        faxField.clear();
        Random r = new Random();
        faxField.sendKeys("new_fax_number: " + Integer.toString(r.nextInt(100)));

        WebElement submit = waitVisibiltyAndFindElement(submitProfileData);
        submit.click();

        return new MyProfilePage(driver);
    }
}
