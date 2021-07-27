package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By userName = By.id("user-name");
    By passWord = By.id("password");
    By loginButton = By.id("login-button");
  //  By epicSadFace = By.className("error-message-container error");
  // By epicSadFace = By.tagName("h3");
    By epicSadFace = By.cssSelector(".error-message-container h3");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserName() {

        return driver.findElement(userName);
    }

    public WebElement getPassWord() {

        return driver.findElement(passWord);
    }

    public WebElement lockOutUser() {

        return driver.findElement(epicSadFace);

    }

    public WebElement loginButton() {
        return driver.findElement(loginButton);
    }

}
