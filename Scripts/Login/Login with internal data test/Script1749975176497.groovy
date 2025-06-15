import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://naveenautomationlabs.com/opencart/index.php?')

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('home_page/My Account2'))

WebUI.click(findTestObject('home_page/My Account2'))

WebUI.click(findTestObject('home_page/Login'))

WebUI.sendKeys(findTestObject('Login/field_email'), username)

WebUI.sendKeys(findTestObject('Login/field_password'), password)

WebUI.click(findTestObject('Login/btn_login'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

if (testType == 'P') {
    WebUI.waitForElementVisible(findTestObject('My_Account/Text_box_Edit_account'), 0)
	WebUI.verifyElementVisible(findTestObject('My_Account/Text_box_Edit_account'), FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.waitForElementVisible(findTestObject('Login/validation_login_class'), 0)
    WebUI.verifyElementPresent(findTestObject('Login/validation_login_class'), 0)
}

WebUI.closeBrowser()

