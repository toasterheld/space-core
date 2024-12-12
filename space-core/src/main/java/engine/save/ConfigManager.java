package engine.save;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * The ConfigManager class is responsible for reading and writing configuration data
 * from JSON files. It provides functionality to retrieve and update values in
 * configuration files for the game.
 */
public class ConfigManager {
    // Path to the main configuration file
    public static final String MAIN_CONFIG_PATH = "config.json";
    // Path to the game-specific configuration file
    public static String gameConfigPath;

    // Gson instance for parsing and writing JSON
    private static Gson gson = new Gson();

    /**
     * Initializes the ConfigManager by loading the main configuration file and
     * retrieving the game configuration path from it.
     */
    public static void init() {
        gameConfigPath = getMainConfigValue("gameConfig");
    }

    /**
     * Retrieves a value from the main configuration file. The path parameter should
     * specify the key hierarchy in the format "key1.key2.key3".
     *
     * @param keyPath the key path to access the desired value (e.g., "key1.key2.key3")
     * @return the value associated with the key path, or null if an error occurs
     */
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

    /**
     * Retrieves a value from the game-specific configuration file. The path parameter
     * should specify the key hierarchy in the format "key1.key2.key3".
     *
     * @param keyPath the key path to access the desired value (e.g., "key1.key2.key3")
     * @return the value associated with the key path, or null if an error occurs
     */
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

    /**
     * Updates the value for a specific key in the game-specific configuration file.
     * The key path parameter specifies the key hierarchy in the format "key1.key2.key3".
     * The new value will be written to the file.
     *
     * @param keyPath the key path to access the value (e.g., "key1.key2.key3")
     * @param value the new value to set for the specified key
     */
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
                writer.write(gson.toJson(config));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
