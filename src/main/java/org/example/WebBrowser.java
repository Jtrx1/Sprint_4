package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.example.Settings.SITE_URL;
import static org.example.Settings.BROWSER;

public class WebBrowser {

   public static WebDriver get() {
      WebDriver driver;
      switch (BROWSER) {
         case "Chrome":
            System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\bin\\chromedriver.exe");
            driver = new ChromeDriver();
            break;
         case "Firefox":
            System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\bin\\geckodriver.exe");
            driver = new FirefoxDriver();
            break;
         default:
            throw new RuntimeException("Некорректный тип браузера. Может быть: \"Chrome\" или \"Firefox\"");
      }
      driver.get(SITE_URL);
      return driver;
   }

}
