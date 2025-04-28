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

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://naveenautomationlabs.com/opencart/index.php?')

WebUI.click(findTestObject('home_page/my account'))

WebUI.click(findTestObject('home_page/Register'))

WebUI.click(findTestObject('Register_page/btn_continue_register'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Register_page/validation_warning'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Register_page/validation_first_name'), 'First Name must be between 1 and 32 characters!')

WebUI.verifyElementVisible(findTestObject('Register_page/validation_last_name'))

WebUI.verifyElementVisible(findTestObject('Register_page/validation_last_name'))

WebUI.verifyElementVisible(findTestObject('Register_page/validation_email'))

WebUI.verifyElementVisible(findTestObject('Register_page/validation_telephone'))

WebUI.verifyElementVisible(findTestObject('Register_page/validation_password'))

WebUI.sendKeys(findTestObject('Register_page/field_first_name'), 'Martin')

WebUI.sendKeys(findTestObject('Register_page/field_last_name'), 'Firmanto')

WebUI.sendKeys(findTestObject('Register_page/field_email'), 'noubouwufridda-7998@yopmail.com')

WebUI.sendKeys(findTestObject('Register_page/Field_telephone'), '088881234')

WebUI.sendKeys(findTestObject('Register_page/field_confirm_password'), 'Test1234!')

WebUI.sendKeys(findTestObject('Register_page/field_password'), 'Test1234!')

WebUI.click(findTestObject('Register_page/Privacy Policy'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Register_page/btn_continue_register'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Register_page/notif_registered'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject(null), FailureHandling.STOP_ON_FAILURE)

