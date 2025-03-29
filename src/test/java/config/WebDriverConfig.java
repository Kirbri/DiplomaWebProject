package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${environment}.properties",
        "classpath:properties/local.properties",
        "system:properties"
})

public interface WebDriverConfig extends Config {

    @Key("browserName")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserWindowSize")
    String getBrowserWindowSize();

    @Key("browserIsRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}