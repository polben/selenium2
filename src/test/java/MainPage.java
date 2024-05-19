import org.openqa.selenium.*;


public class MainPage extends BasePage{
    private By footerLocator = By.xpath("//footer[@class='d-print-none']");
    private By cookieLocator = By.xpath("//a[@class='btn btn-primary nanobar-btn js-nanobar-close-cookies']");
    private By loginButtonLocator = By.xpath("//div[@class='header-navbar-top-right-item header-navbar-top-right-login']");

    public MainPage(WebDriver webDriver){
        super(webDriver);
        this.driver.get("https://shop.cafefrei.hu/");
    }

    public String getFooter(){
        WebElement webElement = waitVisibiltyAndFindElement(footerLocator);
        return webElement.getText();
    }

    public LoginPage login() throws InterruptedException {
        WebElement cookieButton = waitVisibiltyAndFindElement(cookieLocator);
        cookieButton.click();
        Thread.sleep(1000); //wait for cookie animation to disappear

        WebElement loginButton = waitVisibiltyAndFindElement(loginButtonLocator);
        loginButton.click();

        return new LoginPage(driver);
    }

}
