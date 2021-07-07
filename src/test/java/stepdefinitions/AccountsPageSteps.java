package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AccountsPage;
import com.pages.Loginpage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	//Initialize all the Page classes and pass the driver

	private Loginpage loginpage=new Loginpage(DriverFactory.getDriver());
	private AccountsPage accountpage;



	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credentialtable) throws InterruptedException {

		List<Map<String,String>> credlist= credentialtable.asMaps();
		String Username=credlist.get(0).get("username");
		String password= credlist.get(0).get("password");
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Thread.sleep(5);
		accountpage = loginpage.doLogin(Username, password);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String AccountTitle = accountpage.getAccPageTitle();
		System.out.println("The Accounts Page Title "+ AccountTitle);

	}

	@Then("user gets Accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expaccountssectionlist=sectionsTable.asList();
		System.out.println("Account Sections names are"+ expaccountssectionlist);
		
		List <String>actaccountsectionlist = accountpage.getAccSectionList();
		Assert.assertTrue(actaccountsectionlist.containsAll(expaccountssectionlist));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer sessioncount) {
		Assert.assertTrue(accountpage.getAccPageSectionCount()== sessioncount);

	}


}
