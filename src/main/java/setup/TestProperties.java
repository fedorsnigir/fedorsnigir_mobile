package setup;

import enums.PropertiesEnum;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    private final String PROPERTIES_FOLDER_PATH = "src/main/resources/properties/";
    protected PropertiesEnum APPLICATION_TYPE;
    private Properties properties = new Properties();

    protected String getProperty(String key) {

        try (InputStream input = new FileInputStream(PROPERTIES_FOLDER_PATH + APPLICATION_TYPE.value + ".properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return properties.getProperty(key);
    }

//    private Properties getCurrentProps() throws IOException {
//        FileInputStream input = new FileInputStream(PROPERTIES_FOLDER_PATH +);
//        properties.load(input);
//        input.close();
//        return properties;
//    }
//
//    protected String getProp(String propKey) throws IOException {
//        if (!properties.containsKey(propKey)) properties = getCurrentProps();
//        return properties.getProperty(propKey, null);
}
