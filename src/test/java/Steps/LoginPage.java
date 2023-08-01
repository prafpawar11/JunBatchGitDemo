package Steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	static WebDriver driver;

	@Given("user open a login page url in {string} browser")
	public void user_open_a_login_page_url_in_browser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
	}

	@When("user enter valid username and valid password and click on login button")
	public void user_enter_valid_username_and_valid_password_and_click_on_login_button(DataTable dataTable)
			throws InterruptedException {

		// List<List<String>> ls = dataTable.asLists();

		List<List<String>> ls = dataTable.cells();
		String username = ls.get(0).get(0);
		String password = ls.get(0).get(1);

		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.name("login-button")).click();

	}

	@Then("user is on home page")
	public void user_is_on_home_page() {

	}

	public static byte[] takeScreenshot() {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

	@Before
	public static void setUp() {

	}

	@After
	public static void tearDown(Scenario scenario) {

		// validate if scenario has failed
		if (scenario.isFailed()) {
			byte[] screenshot = LoginPage.takeScreenshot();
			scenario.attach(screenshot, "image/png", scenario.getName());

		} else {
			byte[] screenshot = LoginPage.takeScreenshot();
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
