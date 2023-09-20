import org.example.pageobject.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import java.util.Arrays;

import static org.example.Settings.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ChecksTextAccordionPanelTest extends BaseTest{
    private final String accordionPanelString;

    public ChecksTextAccordionPanelTest(String accordionPanelString){
        this.accordionPanelString=accordionPanelString;
    }
    @Parameterized.Parameters
    public static String[] getTestString() {
        return ACCORDION_PANEL_STRINGS;
    }

    @Test
    public void accordionPanelTest(){
        System.out.println(accordionPanelString);
        int i = Arrays.asList(ACCORDION_PANEL_STRINGS).indexOf(accordionPanelString);
        MainPage objPage=new MainPage(driver);
        objPage.clickAccordionHeading(objPage.getAccordionHeading(), i);
        assertEquals("Ошибка при проверке панели вопросов: ", accordionPanelString,
               driver.findElement(By.xpath(String.format("//div[@id='accordion__panel-%d']/p", i))).getText());
    }
}
