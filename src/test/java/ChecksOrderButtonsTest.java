
import org.example.pageobject.OrderPage;
import org.example.pageobject.MainPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.example.Settings.FIRST_ORDER;
import static org.example.Settings.SECOND_ORDER;


@RunWith(Parameterized.class)
public class ChecksOrderButtonsTest extends BaseTest {
    private final String name;
    private final String lName;
    private final String address;
    private final String station;
    private final String telephoneNumber;

    private final String date;
    private final String value;
    private final String color;

    public ChecksOrderButtonsTest(String name,String lName, String address, String station, String telephoneNumber, String thisdata, String value, String color) {
        this.name = name;
        this.lName = lName;
        this.address = address;
        this.station = station;
        this.telephoneNumber = telephoneNumber;
        this.date = thisdata;
        this.value = value;
        this.color = color;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                FIRST_ORDER,
                SECOND_ORDER,
        };
    }
    @Test
    public void CheckTopButton(){
        MainPage nPage = new MainPage(driver);
        nPage.clickTopOrderButton();
        OrderPage nePage = new OrderPage(driver);
        nePage.fillingOrder(name, lName, address, station, telephoneNumber, date, value, color);
        Assert.assertTrue("Нет кнопки проверить заказ", driver.findElement(nePage.getOrderIsProcessed()).isDisplayed());
    }
    @Test
    public void CheckInsideButton(){
        MainPage nPage = new MainPage(driver);
        nPage.clickInsideOrderButton();
        OrderPage nePage = new OrderPage(driver);
        nePage.fillingOrder(name, lName, address, station, telephoneNumber, date, value, color);
        Assert.assertTrue("Нет кнопки проверить заказ",driver.findElement(nePage.getOrderIsProcessed()).isDisplayed());
    }

}
