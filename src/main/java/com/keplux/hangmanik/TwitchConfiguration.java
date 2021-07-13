package com.keplux.hangmanik;

public class TwitchConfiguration {
    private String botName;
    private String channel;
    private String oauth;

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
