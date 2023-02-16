package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

  /*  public void type(By locator, String text) {
        if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
*/
    public void type(By locator,String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.sendKeys(Keys.CONTROL+"a");// CTRL + a выбор всех элементов в окне
        element.sendKeys(Keys.BACK_SPACE);
        if(text!=null){
            element.sendKeys(text);
        }
    }



    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
