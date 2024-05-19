import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeleniumTestTwo {

    private WebDriver driver;


    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void shouldGetFooter(){//static
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.getFooter().contains("cafefrei.webshop@prd-hungary.hu"));
    }

    @Test
    public void shouldGetMainBody(){//static
        MainPage mainPage = new MainPage(driver);
        assertTrue(mainPage.getBody().contains("GYIK"));
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.login();
        MyProfilePage myProfilePage = loginPage.sendCredentials();

        String myProfileTitle = myProfilePage.getTitleText();
        String expectedTitle = "FI?KOM";
        for(int i = 0; i < myProfileTitle.length(); i++){
            if(expectedTitle.charAt(i) != '?') {
                assertEquals(myProfileTitle.charAt(i), expectedTitle.charAt(i));
            }
        }
    }

    @Test
    public void shouldLogout() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.login();
        MyProfilePage myProfilePage = loginPage.sendCredentials();
        String myProfileTitle = myProfilePage.getTitleText(); //wait for profile page to load


        LoginPage loggedOut = myProfilePage.logOut();
        String expectedLoginPageTitle = "BEL?P?S";
        String loginTitle = loggedOut.getTitleText();

        for(int i = 0; i < expectedLoginPageTitle.length(); i++){
            if(expectedLoginPageTitle.charAt(i) != '?') {
                assertEquals(expectedLoginPageTitle.charAt(i), loginTitle.charAt(i));
            }
        }
    }

    @Test
    public void shouldAddFaxDataFormAfterLogin() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.login();
        MyProfilePage myProfilePage = loginPage.sendCredentials();
        ProfileDetails profileDetails = myProfilePage.enterProfileDetails();


        myProfilePage = profileDetails.setFaxData();
        assertTrue(myProfilePage.getUpdateSuccess());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
