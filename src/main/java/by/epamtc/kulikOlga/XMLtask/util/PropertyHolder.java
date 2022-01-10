package by.epamtc.kulikOlga.XMLtask.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyHolder {
    private final static String PROPERTY_FILE_PATH = "D:\\JAVA\\Java lessons\\XMLTask\\src\\main\\resources\\propertyfile.properties";

    public static String getProperty(String key) throws IOException {
        String propertyValue;
        File file = new File(PROPERTY_FILE_PATH);
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        propertyValue = properties.getProperty(key);
        return propertyValue;
    }
}
