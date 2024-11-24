package engine.save;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConfigManager {
    public static final String MAIN_CONFIG_PATH = "config.json";
    public static String gameConfigPath;

    private static Gson gson = new Gson();

    public static void init() {
        gameConfigPath = getMainConfigValue("gameConfig");
    }

    // get a value from the config file. The path parameter format is "key1.key2.key3"
    public static String getMainConfigValue(String keyPath) {
        try {
            Reader reader = new InputStreamReader(ConfigManager.class.getClassLoader().getResourceAsStream(MAIN_CONFIG_PATH));
            JsonObject config = gson.fromJson(reader, JsonObject.class);
            String[] keys = keyPath.split("\\.");
            JsonObject current = config;
            for (int i = 0; i < keys.length - 1; i++) {
                current = current.getAsJsonObject(keys[i]);
            }
            return current.get(keys[keys.length - 1]).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getGameConfigValue(String keyPath) {
        try {
            Reader reader = new InputStreamReader(ConfigManager.class.getClassLoader().getResourceAsStream(gameConfigPath));
            JsonObject config = gson.fromJson(reader, JsonObject.class);
            String[] keys = keyPath.split("\\.");
            JsonObject current = config;
            for (int i = 0; i < keys.length - 1; i++) {
                current = current.getAsJsonObject(keys[i]);
            }
            return current.get(keys[keys.length - 1]).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setGameConfigValue(String keyPath, String value) {
        try {
            // Load the existing JSON configuration
            Reader reader = new InputStreamReader(ConfigManager.class.getClassLoader().getResourceAsStream(gameConfigPath));
            JsonObject config = gson.fromJson(reader, JsonObject.class);
            reader.close();

            // Navigate to the correct JSON object and set the value
            String[] keys = keyPath.split("\\.");
            JsonObject current = config;
            for (int i = 0; i < keys.length - 1; i++) {
                current = current.getAsJsonObject(keys[i]);
            }
            current.addProperty(keys[keys.length - 1], value);

            // Write the updated JSON object back to the file
            File file = new File(ConfigManager.class.getClassLoader().getResource(gameConfigPath).toURI());
            try (FileWriter writer = new FileWriter(file)) {
                //gson.toJson(config, writer);
                writer.write(gson.toJson(config));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}