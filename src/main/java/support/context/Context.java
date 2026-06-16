package support.context;

import io.cucumber.java.Scenario;
import support.context.browser.Web;
import support.context.config.Config;
import support.context.report.Report;

public class Context {

    private static Web web;
    private static Config config;
    private static Report report;
    private static Scenario scenario;

    public Context() {
        setup();
    }

    public void setup(){
        report = new Report();
        config = new Config();
        scenario = getScenario();
        if(web == null){
            web = new Web();
        }
        report.setEnv();
    }

    public static Scenario getScenario() {
        return scenario;
    }

    public static void setScenario(Scenario scenario) {
        Context.scenario = scenario;
    }

    public static Report report() {
        return report;
    }

    public static Web web() {
        return web;
    }

    public static Config config() {
        return config;
    }
}
