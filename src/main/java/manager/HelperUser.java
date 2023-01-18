package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        //wd.findElement(By.cssSelector("")).click();//нажать на логин
        click(By.cssSelector(""));
    }

    public void fillLoginRegistrationForm(String email, String password) {
        type(By.cssSelector(""),email);
        type(By.cssSelector(""),password);

    }
    public void submitLogin(){

    }

}
