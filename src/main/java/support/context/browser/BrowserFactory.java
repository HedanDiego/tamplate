package support.context.browser;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;

import static support.context.Context.config;
import static support.context.Context.web;

public enum BrowserFactory {

    CHROMIUM {
        @Override
        public void createInstance() {
            web().setBrowser(Playwright.create().chromium().launch(getLaunchOptions()));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public BrowserType.LaunchOptions getLaunchOptions() {
            return new BrowserType.LaunchOptions().setHeadless(config().getHeadLess());
        }
    },
    CHROME {
        @Override
        public void createInstance() {
            web().setBrowser(Playwright.create().chromium().launch(getLaunchOptions()));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public BrowserType.LaunchOptions getLaunchOptions() {
            return new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(config().getHeadLess());
        }
    },
    EDGE {
        @Override
        public void createInstance() {
            web().setBrowser(Playwright.create().chromium().launch(getLaunchOptions()));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public BrowserType.LaunchOptions getLaunchOptions() {
            return new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(config().getHeadLess());
        }
    },
    FIREFOX {
        @Override
        public void createInstance() {
            web().setBrowser(Playwright.create().firefox().launch(getLaunchOptions()));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public BrowserType.LaunchOptions getLaunchOptions() {
            return new BrowserType.LaunchOptions().setHeadless(config().getHeadLess());
        }

    },
    WEBKIT {
        @Override
        public void createInstance() {
            web().setBrowser(Playwright.create().webkit().launch(getLaunchOptions()));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public BrowserType.LaunchOptions getLaunchOptions() {
            return new BrowserType.LaunchOptions().setHeadless(config().getHeadLess());
        }
    },
    REMOTE {
        @Override
        public void createInstance() {
            String urlRemote = config().getPropsEnv().urlRemote();
            web().setBrowser(Playwright.create().chromium().connectOverCDP(urlRemote));
            web().setBrowserContext(web().getBrowser().newContext());
        }

        @Override
        public Object getLaunchOptions() {
            return null;
        }
    };

    public abstract Object getLaunchOptions();
    public abstract void createInstance();
}
