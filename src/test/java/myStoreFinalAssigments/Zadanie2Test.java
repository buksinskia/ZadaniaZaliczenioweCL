package myStoreFinalAssigments;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucamber/Features/presta-shop-basket.feature",
        plugin = {"pretty", "html:out/report.html"})
public class Zadanie2Test {
}
