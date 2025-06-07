package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By usernameTextBox =  By.name("email");
	private By PasswordTextBox = By.name("password");
	private By LoginButton = By.cssSelector("button[data-qa='login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(PasswordTextBox).clear();
		driver.findElement(PasswordTextBox).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(LoginButton).click();
		
	}

}
