import org.example.pageobject.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.example.Settings.ACCORDION_PANEL_STRINGS;


public class ChecksTextAccordionPanelTest extends BaseTest{
    @Test
    public void accordionPanelTest(){
        for (int i = 0; i < 7; i++) {
            MainPage objPage=new MainPage(driver);
            objPage.clickAccordionHeading(objPage.getAccordionHeading(), i);
                    assertEquals("Ошибка при проверке панели вопросов: ",ACCORDION_PANEL_STRINGS[i],
                            driver.findElement(By.xpath(String.format("//div[@id='accordion__panel-%d']/p", i))).getText());
        }
    }
}
