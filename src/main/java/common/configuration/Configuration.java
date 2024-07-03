package common.configuration;


import org.aeonbits.owner.Config;

@Config.Sources("classpath:configuration.properties")
public interface Configuration extends Config {

    @Key("reusewebdriver")
    boolean reusewebdriver();
    String browser();
    String driverType();
}
