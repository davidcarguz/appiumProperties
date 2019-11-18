package test.appium.MobilePageObject.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = "src/test/resources/features/"
,glue = "test.appium.MobilePageObject.definitions"
,tags = "@login_exitoso"
,snippets = SnippetType.CAMELCASE
)

public class LoginRunner {

}