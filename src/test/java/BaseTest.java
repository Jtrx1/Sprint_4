import org.example.WebBrowser;

import org.junit.After;

import org.junit.Before;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void init() {
    driver = WebBrowser.get();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After
    public void exit(){
        driver.quit();
    }

}
