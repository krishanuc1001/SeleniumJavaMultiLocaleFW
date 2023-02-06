package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {

    public ReadProperties() {
    }

    private Properties properties;
    private FileInputStream fis;

    public Properties initProp() {
        String language = System.getProperty("lang");
        System.out.println("Language => " + language);
        properties = new Properties();

        try {
            switch (language.toLowerCase()) {
                case "english":
                    fis = new FileInputStream("./src/test/resources/config/lang.en.properties");
                    break;
                case "french":
                    fis = new FileInputStream("./src/test/resources/config/lang.fr.properties");
                    break;
                default:
                    System.out.println("<<=========== The language " + language + "passed does not have its properties file created !!! ===========>>");
                    break;
            }
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
