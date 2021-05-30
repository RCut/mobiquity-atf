package com.mobiquity.test.backend;

import com.mobiquity.test.backend.configuration.BackendTestConfiguration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/mobiquity/test/backend",
        glue = {
                "com.mobiquity.test.backend",
                "com.mobiquity.test.common"
        },
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
@SpringBootTest(classes = BackendTestConfiguration.class)
@CucumberContextConfiguration
@EnableConfigurationProperties
public class RunBackendCukeTest {
}
