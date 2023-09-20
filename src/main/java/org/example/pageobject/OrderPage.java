package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Objects;


public class OrderPage {
   private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //локатор поля "Имя"
    private final By firstName = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    //локатор поля "Фамилия"
    private final By lastName = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    //локатор поля "адрес"
    private final By orderAddress = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для поля "Метро"
    private final By metro = By.xpath("//div[@class='select-search__value']//input");
    //локатор поля "Телефон"
    private final By telephone = By.xpath("//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор кнопки "Далее"
    private final By next= By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор поля даты аренды
    private final By data=By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //локатор кнопки с выпадающим списком
    private final By rentalTime = By.xpath("//*[@class='Dropdown-control']");
    //текст для выбора значения выпадающего списка
    private final String dropDownValue = "//div[@class='Dropdown-menu']/div[text()='%s']";
    //Локатор кнопки цвета самоката "черный жемчуг"
    private final By blackColor=By.id("black");
    //Локатор кнопки цвета самоката "серая безысходность"
    private final By greyColor=By.id("grey");
    //Локатор кнопки "Заказать"
    private final By order=By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор кнопки "Да" подтверждение заказа
    private final By yesButton=By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    //Локатор кнопки "Проверить заказ"
    private  final By orderIsProcessed=By.xpath("//div[@class='Order_NextButton__1_rCA']//button[@class]");
    //заполняем поле "Имя"
    public void enterFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    //заполняем поле "Фамилия"
    public void enterLastName(String lName){
        driver.findElement(lastName).sendKeys(lName);
    }
    //заполняем поле "Адрес"
    public void enterOrderAddress(String address){
        driver.findElement(orderAddress).sendKeys(address);
    }
    //выбираем станцию метро в поле "Метро"
    public void setStation(String station) {
        driver.findElement(metro).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }
    //Заполняем поле "Телефон"
    public void enterTelephone(String telephoneNumber){
        driver.findElement(telephone).sendKeys(telephoneNumber);
    }
    //Нажимаем "Далее"
    public void clickNext(){
        driver.findElement(next).click();
    }
    //заполняем дату аренды
    public void enterData(String thisdata){
      driver.findElement(data).sendKeys(thisdata, Keys.ENTER);
    }
    //заполняем время аренды в выпадающем списке
    public void enterRentalTime(String value){
     driver.findElement(rentalTime).click();
     driver.findElement(By.xpath(String.format(dropDownValue, value))).click();
    }
    //Выбираем цвет самоката. Если такого цвета нет, то галочки не проставляются
    public void enterColor(String color){
     if (Objects.equals(color, "чёрный жемчуг")) {
      driver.findElement(blackColor).click();
     }if (Objects.equals(color, "серая безысходность"))
       driver.findElement(greyColor).click();
     }
    //Нажимаем кнопку Заказать
    public void clickOrder(){
    driver.findElement(order).click();
    }
    //Нажимаем ДА. Подтверждаем заказ
    public void clickYesButton(){
    driver.findElement(yesButton).click();
    }
    //Заполняем данные заказа
    public void fillingOrder(String name,String lName, String address, String station, String telephoneNumber, String thisdata, String value, String color){
     enterFirstName(name);
     enterLastName(lName);
     enterOrderAddress(address);
     setStation(station);
     enterTelephone(telephoneNumber);
     clickNext();
     enterData(thisdata);
     enterRentalTime(value);
     enterColor(color);
     clickOrder();
     clickYesButton();
    }
    //метод для возвращения кпопки "Проверить заказ"
   public By getOrderIsProcessed(){
     return orderIsProcessed;
   }

}


