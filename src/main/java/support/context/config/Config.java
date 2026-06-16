package support.context.config;

import com.github.javafaker.Faker;
import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import support.context.config.functions.IDatePicker;

import java.util.Locale;

public class Config implements IDatePicker {

    private boolean headLess;
    private String browser;
    private String env;
    private Configuration propsEnv;
    private Faker faker;

    public Config() {
        this.setPropsEnv(ConfigCache.getOrCreate(Configuration.class));
        this.setHeadLess(Boolean.parseBoolean(System.getProperty("headless")));
        this.setBrowser(System.getProperty("browser"));
        this.setEnv(System.getProperty("env"));
        setPropsEnv(ConfigCache.getOrCreate(Configuration.class));
        ConfigFactory.setProperty("env", getEnv());
        this.faker = new Faker(new Locale(getPropsEnv().faker()));
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public boolean getHeadLess() {
        return headLess;
    }

    public void setHeadLess(boolean headLess) {
        this.headLess = headLess;
    }

    public Configuration getPropsEnv() {
        return propsEnv;
    }

    public void setPropsEnv(Configuration propsEnv) {
        this.propsEnv = propsEnv;
    }

    public Faker getFaker() {
        return faker;
    }
}
