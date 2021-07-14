package com.keplux.hangmanik;

import com.gikk.twirk.Twirk;
import com.gikk.twirk.TwirkBuilder;

import java.io.IOException;

/**
 * Represents the Twitch bot. This class makes use of Gikkman's Twirk project.
 * You can find more information about it
 * <a href="https://github.com/Gikkman/Java-Twirk">here</a>.
 *
 * @see <a href="https://github.com/Gikkman/Java-Twirk">Twirk</a>
 */
public class Bot {

    private final Twirk twirk;

    /**
     * The constructor takes in the Twitch configuration settings object,
     * whose data is needed to run the Bot.
     * @param config The Twitch configuration settings object.
     */
    public Bot(TwitchConfiguration config) {
        twirk = new TwirkBuilder(
                config.getChannel(),
                config.getBotName(),
                config.getOauth())
                .setVerboseMode(true)
                .build();
    }

    /**
     * Connect to the Twitch server.
     * @throws IOException There was an IOException.
     * @throws InterruptedException The connection was interrupted.
     */
    public void connect() throws IOException, InterruptedException {
        twirk.connect();
    }

    /**
     * Close the connection to the Twitch server.
     */
    public void close() {
        twirk.close();
    }
}
