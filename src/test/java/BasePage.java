import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    private By bodyLocator = By.xpath("//body");


    protected WebElement waitVisibiltyAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public BasePage(WebDriver webDriver){
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, 10);


    }

    public String getBody(){
        WebElement webElement = waitVisibiltyAndFindElement(bodyLocator);
        return webElement.getText();
    }


    protected void sleep(int ms){
        try{
            Thread.sleep(ms);
        }catch (Exception e){}
    }
}
