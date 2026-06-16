package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import support.context.browser.BrowserFactory;
import support.context.Context;

@Log4j2
public class Hook extends Context {

    @Before
    public void beforeScenario(Scenario scenario) {
        setScenario(scenario);
        log.info(String.format("TESTE INICIADO: %s", getScenario().getName()));
        BrowserFactory.valueOf(config().getBrowser().toUpperCase()).createInstance();

        if (web().pageExist())
            web().createNewPage();
    }

    @AfterStep
    public void afterStep() {
        report().takeScreenShot();
    }

    @After
    public void afterScenario() {
        web().finishScenario();
        log.info(String.format("TESTE FINALIZADO: %s", getScenario().getName()));
        log.info(String.format("TESTE STATUS: %s", getScenario().getStatus()));
    }

}









