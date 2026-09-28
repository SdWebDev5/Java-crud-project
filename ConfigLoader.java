import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try {
            // File ko load karna (Static block me taaki ek hi baar load ho)
            FileInputStream fis = new FileInputStream("config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            System.out.println("Error: config.properties file nahi mili!");
            e.printStackTrace();
        }
    }

    // Kisi bhi key ki value nikalne ke liye method
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
