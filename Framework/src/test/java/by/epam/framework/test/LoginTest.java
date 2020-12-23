package by.epam.framework.test;

import by.epam.framework.model.User;
import by.epam.framework.page.LoginPage;
import by.epam.framework.page.MainPage;
import by.epam.framework.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonConditions {

    @Test
    public void loginTest(){
       User user= UserCreator.withCredentialsFromProperty();
       String userEmail=new LoginPage(driver)
               .openPage()
               .login(user)
               .openPage()
               .closePopup()
               .openMyAccount()
               .getLoggedInUserEmail();
        Assert.assertEquals(userEmail,user.getUserEmail());
    }

    @Test
    public void loginNegativeTest(){
        User user= new User("email.com","password");
        LoginPage actualPage=new LoginPage(driver)
                .openPage();
        MainPage expectedPage=new MainPage(driver);
        Assert.assertNotEquals(expectedPage, actualPage);
    }
}
