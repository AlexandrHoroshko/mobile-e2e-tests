import java.io.FileInputStream;
import java.util.Properties;

public final class Config {

    public static Properties loadProperties(OSEnum os) {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(String.format("config_%s.properties", os.getValue()));
            properties.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

}
