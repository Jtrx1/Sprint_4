package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //локатор для верней кнопки "Заказать"
    private final By topOrderButton = By.className("Button_Button__ra12g");
    //локатор нижней кнопки "Заказать"
    private final By insideOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[@class]");
    //строка для определения панелей в Важных вопросах
    private final String accordionPanel = "accordion__heading-";
    //нажимаем верхнюю кнопку "Заказать"
    public void clickTopOrderButton(){
        driver.findElement(topOrderButton).click();
    }
    //нажимаем нижнюю кнопку "Заказать"
    public void clickInsideOrderButton() {
        WebElement element = driver.findElement(insideOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    //нажимаем на кнопку в панели вопросов
    public void clickAccordionHeading(String accordionPanel, int i){
        By accordionHeading=By.id(accordionPanel+i);
        WebElement element = driver.findElement(accordionHeading);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public String getAccordionHeading(){
    return accordionPanel;
    }
    //Возвращяем текст из соответствующего элемента из панели вопросов на сайте

}
