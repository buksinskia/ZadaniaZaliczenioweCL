package myStoreFinalAssigments;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucamber/Features/zd1-add-new-adress.feature",
        plugin = {"pretty", "html:out/report.html"})
public class Zad1Test {
}
