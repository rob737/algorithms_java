package adhoc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("db.properties file not found in classpath");
            }
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String getDbUrl() {
        return get("db.url");
    }

    public static String getDbUsername() {
        return get("db.username");
    }

    public static String getDbPassword() {
        return get("db.password");
    }
}
