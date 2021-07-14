package com.keplux.hangmanik;

import java.io.*;
import java.util.Properties;

public class TwitchConfiguration {
    private String botName;
    private String channel;
    private String oauth;

    public TwitchConfiguration() {

    }

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

    public void loadConfigFile() {
        try (InputStream is = new FileInputStream("src/main/resources/static/config.properties")) {
            Properties prop = new Properties();
            prop.load(is);

            botName = prop.getProperty("botName");
            channel = prop.getProperty("channel");
            oauth = prop.getProperty("oauth");

            System.out.println("config.properties loaded.");
        }
        catch (FileNotFoundException e) {
            try {
                Properties prop = new Properties();
                File file = new File("src/main/resources/static/config.properties");
                prop.store(new FileOutputStream(file), "Create config.properties");
                System.out.println("config.properties created.");
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

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
