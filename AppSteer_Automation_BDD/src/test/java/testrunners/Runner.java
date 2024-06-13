package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resource/",
glue = { "stepDefinations", "hooks" }, 
plugin = { "pretty"}, 
 tags = "@Appspace1" // Specify the tag(s) here
)
public class Runner{	

}
