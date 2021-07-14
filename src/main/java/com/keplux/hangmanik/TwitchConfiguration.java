package com.keplux.hangmanik;

import org.springframework.ui.Model;

import java.io.*;
import java.util.Properties;

/**
 * Object representing the Twitch authentication/login information.
 */
public class TwitchConfiguration {
    private final String configPath = "src/main/resources/static/config.properties";

    private String botName;
    private String channel;
    private String oauth;

    // Default constructor
    public TwitchConfiguration() {

    }

    // Constructor to build a new config object.
    public TwitchConfiguration(TwitchConfigurationBuilder builder) {
        botName = builder.botName;
        channel = builder.channel;
        oauth = builder.oauth;
    }

    public String getBotName() {
        return botName;
    }

    public String getChannel() {
        return channel;
    }

    public String getOauth() {
        return oauth;
    }

    /**
     * Save the TwitchConfiguration object's data to the config.properties file.
     * @param config The object holding the data to be saved.
     */
    public void store(TwitchConfiguration config) {
        // Load the properties file.
        try (InputStream is = new FileInputStream(
                "src/main/resources/static/config.properties")) {
            Properties prop = new Properties();
            prop.load(is);
            is.close();

            // Write contents to properties file
            FileOutputStream os = new FileOutputStream(configPath);
            prop.setProperty("botName", config.botName);
            prop.setProperty("channel", config.channel);
            prop.setProperty("oauth", config.oauth);

            prop.store(os, null);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Load the configuration file into the model.
     * @param model The model the data will be loaded into.
     */
    public void loadConfigFile(Model model) {
        // When the file exists, load it and send the data to the model.
        try (InputStream is = new FileInputStream(configPath)) {
            Properties prop = new Properties();
            prop.load(is);

            botName = prop.getProperty("botName");
            channel = prop.getProperty("channel");
            oauth = prop.getProperty("oauth");

            model.addAttribute("botName", botName);
            model.addAttribute("channel", channel);
            model.addAttribute("oauth", oauth);

            System.out.println("config.properties loaded.");
        }
        // If the file doesn't exist, create it.
        catch (FileNotFoundException e) {
            try {
                Properties prop = new Properties();
                File file = new File(configPath);
                prop.store(new FileOutputStream(file), "Twitch Connection Configuration");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Bot Name: " + botName + "\n" +
                "Channel: " + channel + "\n" +
                "OAuth: " + oauth + "\n";
    }

    /**
     * Builder class to help build the configuration object.
     */
    public static class TwitchConfigurationBuilder {
        private String botName;
        private String channel;
        private String oauth;

        public TwitchConfigurationBuilder botName(String botName) {
            this.botName = botName;
            return this;
        }

        public TwitchConfigurationBuilder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public TwitchConfigurationBuilder oauth(String oauth) {
            this.oauth = oauth;
            return this;
        }

        public TwitchConfiguration setConfig() {
            TwitchConfiguration config = new TwitchConfiguration(this);
            return config;
        }

        private void validate(TwitchConfiguration config) {
            if (config.channel.startsWith("#")) {
                config.channel = config.channel.substring(1);
            }
            if (config.oauth.startsWith("oauth:")) {
                config.oauth = config.oauth.split(":")[1];
            }
        }
    }
}
