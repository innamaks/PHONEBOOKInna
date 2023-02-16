package manager;

import model.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        //wd.findElement(By.cssSelector("")).click();//нажать на логин
        click(By.cssSelector("a[href='/login']"));
        //click(By.cssSelector("a[href='/l']"));

    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.name("email"), email);//пишем
        type(By.name("password"), password);//пишем

    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());//пишем
        type(By.name("password"), user.getPassword());//пишем

    }


    public void submitLogin() {
        click(By.cssSelector("[name='login']"));//логинимся нажимаем кнопку

    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    //проверка правда ли элемент появиллся
    // try {
    //    return wd.findElement(By.xpath("//button[text()='Sign Out']")).isDisplayed();
    //   return true;
    //isDisplaed---отображение только когда открыта сраница с данным элементом
    // }catch (Exception e){
    // return false;
    // }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }


    public boolean isErrorMessageDisplayed(String message) {
        // Alert alert = wd.switchTo().alert();
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(9)).until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println(text);

        alert.accept();

        return text.contains(message);
    }

    public boolean isErrorMessageDisplayedOld(String message) {

        Alert alert = wd.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        // click --- ok
        alert.accept();
        //click cancel
        //click dismiss()
        // alert.sendKeys("Hello")
        //return text.equals(message);
        return text.contains(message);
    }


    public void submitRegistration() {
        click(By.cssSelector("[name='registration']"));


    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
