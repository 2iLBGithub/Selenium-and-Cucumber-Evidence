package MainDirectory;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines({"cucumber"})
@SelectClasspathResource("org")
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "pretty"
)
public class RunCucumberTest {
    public RunCucumberTest() {
    }
}
