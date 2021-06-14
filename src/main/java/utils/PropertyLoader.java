package utils;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROPERTIES_PATH = "/application.properties";

    public static String getProperty(String propertyName) {
        return getPropertiesInstance().getProperty(propertyName);
    }

    @SneakyThrows(IOException.class)
    private static Properties getPropertiesInstance() {
        Properties instance = new Properties();
        try (InputStream resourceStream = PropertyLoader.class.getResourceAsStream(PROPERTIES_PATH);
             InputStreamReader inputStream = new InputStreamReader(resourceStream, StandardCharsets.UTF_8)) {
            instance.load(inputStream);
        }
        return instance;
    }

    private PropertyLoader() {
    }
}
