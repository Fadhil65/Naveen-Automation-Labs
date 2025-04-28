package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

public class Login {

	@Given("The User go to login page")
	public void the_User_go_to_login_page() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.Url)
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://naveenautomationlabs.com/opencart/index.php?')
	}

	@And("User click My Account")
	public void user_click_My_Account() {
		WebUI.click(findTestObject('home_page/my account'))
	}

	@When("User click Login")
	public void user_click_Login() {
		WebUI.click(findTestObject('home_page/Login'))
	}

	@When("User performs two login attempts with valid credetials and invalid credentials")
	public void user_performs_two_login_attempts_with_valid_credetials_and_invalid_credentials() {
		for (int i = 0; i < 2; i++) {
			WebUI.comment("iterasi ke -${i + 1}")

			if (i == 0) {
				// Iterasi pertama - valid login
				WebUI.sendKeys(findTestObject('Login/field_email'), GlobalVariable.valid_email)
				WebUI.sendKeys(findTestObject('Login/field_password'), GlobalVariable.valid_password)
				WebUI.click(findTestObject('Login/btn_login'), FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementVisible(findTestObject('My_Account/Text_box_Edit_account'), 0)
				WebUI.verifyElementVisible(findTestObject('My_Account/Text_box_Edit_account'), FailureHandling.STOP_ON_FAILURE)

				//logout
				WebUI.click(findTestObject('My_Account/Text_box_Logout'), FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(1)
				WebUI.click(findTestObject('My_Account/Text_box_Login'), FailureHandling.STOP_ON_FAILURE)

			} else {
				// Iterasi kedua - invalid login
				WebUI.comment("login invalid pada iterasi ke-${i + 1}")
				WebUI.sendKeys(findTestObject('Login/field_email'), GlobalVariable.invalid_email)
				WebUI.sendKeys(findTestObject('Login/field_password'), GlobalVariable.invalid_password)
				WebUI.click(findTestObject('Login/btn_login'), FailureHandling.STOP_ON_FAILURE)
				

				// Validasi error muncul
				if (WebUI.verifyElementVisible(findTestObject('Login/validation_login'), FailureHandling.OPTIONAL)) {
					WebUI.comment("✅ Validasi error muncul saat login invalid - Iterasi ke -${i + 1}")
				} else {
					WebUI.comment("❌ Tidak ada error saat password invalid - Kemungkinan BUG")
				}
			}

			WebUI.delay(1)

		}

WebUI.closeBrowser()


		
	}
}
