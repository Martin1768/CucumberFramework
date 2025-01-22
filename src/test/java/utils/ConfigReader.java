package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getProperty(String property) {
        Properties properties = new Properties();

        try(FileInputStream f = new FileInputStream(Constants.CONFIG_FILE_PATH)) {
            properties.load(f);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
