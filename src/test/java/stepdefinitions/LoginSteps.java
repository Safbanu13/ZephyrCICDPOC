package stepdefinitions;

import org.testng.Assert;

import com.pages.Loginpage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
	private static String title;


	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

	}

	@When("user gets the title of the page")
	
		public void user_gets_the_title_of_the_page() {
			title = loginpage.getTitleLoginTitle();
			System.out.println("Page title is: " + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitlename) {

		title=loginpage.getTitleLoginTitle();
		System.out.println("Login Page title is"+ title);
		Assert.assertTrue(title.contains(expectedtitlename));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {	
		Assert.assertTrue(loginpage.isForgotpwdlinkexist());

	}

	@And("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterusername(username);

	}

	@And("user enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterpwd(password);

	}
	
	

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.ClickOnLogin();}

	


}


