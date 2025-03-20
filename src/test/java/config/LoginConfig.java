package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${environment}.properties",
        "system:properties"
})

public interface LoginConfig extends Config {
    @Key("remoteUser")
    String getRemoteUser();

    @Key("remotePassword")
    String getRemotePassword();
}
