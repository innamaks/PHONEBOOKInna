package tests;

import manager.DataProviderUser;
import manager.ListenerTNG;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners(ListenerTNG.class)
public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("I need logout");
            //  Sig nout-если эта кнопка есть то надо делать логаут
        }
    }

    @Test(dataProvider = "loginData")

    public void loginSuccess(String email,String password) {
        //позетивный сценарий
       // logger.info("Login with valid data : email: 'innayrchenko77@gmail.com' & password: AlisMaksim2!");
        logger.info("Login with valid data : email: " + email + " & password: " + password );
        app.getHelperUser().openLoginRegistrationForm();
       // app.getHelperUser().fillLoginRegistrationForm("innayrchenko77@gmail.com", "AlisMaksim2!");
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");
        //logout
    }

    @Test(invocationCount = 2)
    public void loginSuccessNew() {
        //позетивный сценарий
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maksim2018@mail.com", "AlisMaksim2&");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test(groups = {"smoke"})
    public void loginWrongEmail() {
        //неготивный неправельный логин
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maksim2018mail.com", "AlisMaksim2$");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword() {
        //негативный неправельный поролль
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maksim2018@mail.com", "AlisMaksi");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }

    @Test
    public void loginUnregisterUser() {
        //негативный залогиниться хочет не зарегистрированый пользователь
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("Mama2018@mail.com", "InnaAlisa2@");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Wrong email or password"));
    }

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"innayrchenko77@gmail.com", "AlisMaksim2!"});
        list.add(new Object[]{"innayrchenko77@gmail.com", "AlisMaksim2!"});
        list.add(new Object[]{"innayrchenko77@gmail.com", "AlisMaksim2!"});

        return list.iterator();
    }
    @Test(dataProvider = "loginDataCls",dataProviderClass = DataProviderUser.class)

    public void loginSuccess2(String email,String password) {//ттест для класса DataProviderUser
        logger.info("Login with valid data : email: " + email + " & password: " + password );
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Tests success");

    }
    @Test(dataProvider = "loginDataUser",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {

        logger.info("Tests start with user model   " + user.toString());
        //позетивный сценарий
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test(dataProvider = "loginDataUserFromFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelFromFile(User user) {

        logger.info("Tests start with user model   " + user.toString());
        //позетивный сценарий
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


}
