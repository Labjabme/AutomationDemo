package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestecHome {
    public WebDriver driver;
    By focusPage = By.xpath("//a[text()='Focus insights']");
    By moneyPage = By.xpath("//a[contains(@href, '/en_za/focus/money')]");
    By understandingPage = By.xpath("//a[contains(@href, '/en_za/focus/money/understanding')]");
    By signUp = By.xpath("//button[@class=\"button-primary content-hub-form-container__button js-content-hub-form-container-button\"]");
    By signUp1 = By.xpath("//button[@class=\"button-primary content-hub-form-container__button js-content-hub-form-container-button\"]");
    By signUp2 = By.xpath("//div[@id='content']/div[7]/div[2]/div/div/div/div/div[2]/div/div[2]/button");
    By signUp3 = By.xpath(("//*/text()[normalize-space(.)='Sign up']/parent::*"));
    By signUp4 = By.xpath("//div[2]/div/div[2]/button");
    By signUp5 = By.xpath("/html/body/div[2]/div[3]/div[7]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/button");
    By nameInput = By.xpath("//input[@name='name']");
    By surnameInput = By.xpath("//input[@name='surname']");
    By emailInput = By.xpath("//input[@name='email']");
    By myselfCheckBox = By.xpath("//div[@id='content']/div[7]/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/form/div/section/fieldset[2]/div[4]/checkbox-input/div/div/div[1]/button");
    By intemediariesBox = By.xpath("//div[@id='content']/div[7]/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/form/div/section/fieldset[2]/div[4]/checkbox-input/div/div/div[2]/button/div");
    By myBusiness = By.xpath("//div[@id='content']/div[7]/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/form/div/section/fieldset[2]/div[4]/checkbox-input/div/div/div[3]/button");
    By submitButton = By.xpath("//button[@type='submit']");
    By thankYouMsg = By.xpath("//h3[@class=\"thank-you__heading\"]");

    public InvestecHome(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement selectFocus() {

        return driver.findElement(focusPage);

    }

    public WebElement selectMoney() {

        return driver.findElement(moneyPage);

    }

    public WebElement selectUnderstanding() {

        return driver.findElement(understandingPage);

    }

    public WebElement signUp() {

        return driver.findElement(signUp);

    }


    public WebElement name() {

        return driver.findElement(nameInput);

    }

    public WebElement surname() {

        return driver.findElement(surnameInput);

    }


    public WebElement email() {

        return driver.findElement(emailInput);

    }

    public WebElement mySelf() {

        return driver.findElement(myselfCheckBox);

    }
    public WebElement intermediariesBox() {

        return driver.findElement(intemediariesBox);

    }
    public WebElement myBusiness() {

        return driver.findElement(myBusiness);

    }
    public WebElement submitButton() {

        return driver.findElement(submitButton);

    }

    public WebElement thankYouMessage() {

        return driver.findElement(thankYouMsg);

    }



}
