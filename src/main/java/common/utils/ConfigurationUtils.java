package common.utils;

import common.configuration.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class ConfigurationUtils {

    public static final Configuration configuration = ConfigFactory.create(Configuration.class, System.getProperties());
}
