package Utilities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

public class PropertiesUtility {

    private PropertiesUtility ()
    {
        super();
    }

    public final static String filePath="src/main/resources";

    public static Properties propertiesLoading()
    {
        Properties loadedProperties = new Properties();
        Collection<File> allPropertiesFiles;
        allPropertiesFiles = FileUtils.listFiles(new File(filePath), new String[]{"properties"},true);
        allPropertiesFiles.forEach(file->{
            try {
                loadedProperties.load(new FileInputStream(file));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            loadedProperties.putAll(System.getProperties());// Copy all existing system properties into the Properties object → makes the Properties object aware of current global properties
        System.getProperties().putAll(loadedProperties);//Copy all properties from the Properties object into the system properties → makes the loaded values globally accessible in the application
        });
        return loadedProperties;
    }


    public static String getPropertyValue(String propertyName)
    {
        return System.getProperty(propertyName);
    }
}
