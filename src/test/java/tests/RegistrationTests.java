package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            //  Sig nout-если эта кнопка есть то надо делать логаут
        }


    }

    @Test(groups = {"smoke", "task"})
    public void registrationSuccess() {
        //позетивный сценарий
        Random random = new Random();//пишем рандомальнные данные чтобы не менять пользователя кот хочет зар.
        int i = random.nextInt(100);
        String email = "lox" + i + "@gmail.com";
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, "AlisMaksim2!");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void registrationWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("loxgmail.com", "AlisMaksim2!");
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password format"));
    }

    @Test
    public void registrationWrongPassword() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("set@gmail.com", "Al12$");
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password format"));
    }

    @Test
    public void registrationUserAlreadyExists() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("innayrchenko77@gmail.com", "AlisMaksim2!");
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("User already exist"));
        //зар..юзерр хочет зарегистрироваться
    }
}
