package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.pages.ContactPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	private ContactPage contactPage = new ContactPage(DriverFactory.getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {

		//System.out.println(System.getProperty("user.dir"));
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(
				".\\src\\test\\resources\\config\\AutomationPracticePage.xlsx",
				sheetName);
		String heading = testdata.get(RowNumber).get("subjectheading");
		String email = testdata.get(RowNumber).get("email");
		String orderref = testdata.get(RowNumber).get("orderref");
		String message = testdata.get(RowNumber).get("message");

		contactPage.fillContactUsForm(heading, email, orderref, message);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactPage.ClickOnSendButton();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expectedMessage) {
		String actualSuccessMeesage = contactPage.getSuccessMesssge();

		Assert.assertEquals(expectedMessage, actualSuccessMeesage);

	}
}
