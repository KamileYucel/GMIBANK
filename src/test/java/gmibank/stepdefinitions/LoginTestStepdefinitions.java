package gmibank.stepdefinitions;

import gmibank.pages.LoginPage;
import gmibank.utilities.ConfigurationReader;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginTestStepdefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("http://gmibank.com/login");

    }

    @Given("user clicks on the username textbox and text {string}")
    public void user_clicks_on_the_username_textbox_and_text(String string) {
       loginPage.usernamebox.sendKeys(string);
    }

    @Given("user clicks on the password textbox and text {string}")
    public void user_clicks_on_the_password_textbox_and_text(String string) {
        loginPage.passwordbox.sendKeys(string);
    }


    @Given("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        loginPage.signInButton.click();
    }

    @Then("user verify to login")
    public void user_verify_to_login() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("GMIBANK"));
    }
    @Given("user clicks on the cancel button")
    public void user_clicks_on_the_cancel_button_button() {

        loginPage.cancelButton.click();
    }

    @Then("user verify to homepage")
    public void user_verify_to_homepage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title= Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("GMIBANK"));

    }
}


