package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(User.builder().email("innayrchenko77@gmail.com").password("AlisMaksim2!").build());
        }
    }

    @Test(groups = {"smoke"})
    public void addContactSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Dina" + i)
                .lastName("Shin")
                .address("Moskovitz")
                .phone("2222222" + i)
                .email("Zara" + i + "@gmail.com")
                .build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        // System.out.println("Submit");
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByEmail(contact.getEmail()));

    }

    @Test
    public void addContactSuccessRequiredFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Marina" + i)
                .lastName("Zara")
                .address("Haifa")
                .phone("2222222" + i)
                .email("Zara" + i + "@gmail.com")
                .build();
        // .description("The best friend").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        // System.out.println("Submit");
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        // app.getHelperContact().pause(10000);
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
        // app.getHelperContact().pause(10000);
        Assert.assertTrue(app.getHelperContact().isContactAddedByEmail(contact.getEmail()));
        logger.info("Tests start with data : " + contact.toString());
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                //пооле имя не заполнено
                .lastName("Zara")
                .address("Haifa")
                .phone("2222222789")
                .email("Zara@gmail.com")
                .description("wrong name").build();
        System.out.println(contact.toString());
        // System.out.println("contact" + contact.getName());
        //проверка это тот жее контакт с имене и без
        //Contact contact1 = Contact.builder()
        // .name("")
        // .lastName("Zara")
        //.address("Haifa")
        //  .phone("2222222789")
        //  .email("Zara@gmail.com")
        //.description("wrong name").build();
        // System.out.println(contact.equals(contact1));// true false
        // System.out.println("contact1" +contact1.getName());


        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //  app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        // app.getHelperContact().pause(10000);
        Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongName1() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Zara")
                .address("Haifa")
                .phone("2222222789")
                .email("Zara@gmail.com")
                .description("wrong name").build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //  app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        // app.getHelperContact().pause(10000);
        Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());

    }


    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder()
                .name("Sara")
                .lastName("")
                .address("Haifa")
                .phone("2222222789")
                .email("Zara@gmail.com")
                .description("wrong Last name").build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        // app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("Baran")
                .lastName("Zara")
                .address("")
                .phone("2222222789")
                .email("Baran@gmail.com")
                .description("wrong address").build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        // app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        // app.getHelperContact().pause(10000);
        Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongPhone() {
        Contact contact = Contact.builder()
                .name("Kalman")
                .lastName("Tulsa")
                .address("Serbia")
                .phone("123")
                .email("Kalman@gmail.com")
                .description("").build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //  app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        //  app.getHelperContact().pause(10000);
        // Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .name("Fur")
                .lastName("Duran")
                .address("Serbia")
                .phone("1234567890")
                .email("Kalmangmail.com")
                .description("").build();
        System.out.println(contact.toString());
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //  app.getHelperContact().pause(10000);
        app.getHelperContact().submitContactForm();
        //  app.getHelperContact().pause(10000);
        // Assert.assertTrue(app.getHelperContact().issAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorMessageDisplayed("Email not valid"));

    }
}