package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ConfigRunner {
    private final WebDriverConfig CONFIG_BROWSER;
    private final LoginConfig CONFIG_CREDENTIALS;

    public ConfigRunner() {
        CONFIG_BROWSER = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        CONFIG_CREDENTIALS = ConfigFactory.create(LoginConfig.class, System.getProperties());

        setupConfiguration();
    }

    private void setupConfiguration() {
        if (CONFIG_BROWSER.isRemote()) {
            Configuration.remote = "https://" + CONFIG_CREDENTIALS.getRemoteUser() + ":" +
                    CONFIG_CREDENTIALS.getRemotePassword() + "@" + CONFIG_BROWSER.getRemoteUrl() + "/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true,
                    "enableVideo", true));
            Configuration.browserCapabilities = capabilities;
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = CONFIG_BROWSER.getBrowserWindowSize();
        Configuration.browserVersion = CONFIG_BROWSER.getBrowserVersion();
        Configuration.browser = CONFIG_BROWSER.getBrowser();
        Configuration.baseUrl = "https://www.avito.ru";
        Configuration.timeout = 30000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.pageLoadStrategy = "normal";
    }
}