package util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ProjectPropertyUtil {
    public static final Logger LOGGER = LogManager.getLogger(ProjectPropertyUtil.class);

    /*
     * Method to read property values for application.properties
     */
    public static String getValue(String propertyName) {

        Properties properties = new Properties();
        String propertyValue = null;

        try {
            properties.load(ProjectPropertyUtil.class.getClassLoader().getResourceAsStream("application.properties"));
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException exception) {
            LOGGER.error("Exception in loading properties");
        }
        LOGGER.debug("[TEST] PropertyName : " + propertyName + " PropertyValue : " + propertyValue);
        return propertyValue;
    }
}
