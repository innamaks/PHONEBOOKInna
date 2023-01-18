package tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginSuccess() {
        //позетивный сценарий
     app.getHelperUser().openLoginRegistrationForm();
     app.getHelperUser().fillLoginRegistrationForm("innayrchenko77@mail.com","AlisMaksim2!");
     app.getHelperUser().submitLogin();
    }

    @Test
    public void loginWrongEmail(){
        //неготивный неправельный логин
    }
    @Test
    public void loginWrongPassword(){
        //негативный неправельный поролль

    }

    @Test
    public void loginUnregisterUser(){
        //негативный залогиниться хочет не зарегистрированый пользователь
    }




}
