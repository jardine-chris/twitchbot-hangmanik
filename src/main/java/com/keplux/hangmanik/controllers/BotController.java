package com.keplux.hangmanik.controllers;

import com.gikk.twirk.Twirk;
import com.gikk.twirk.TwirkBuilder;
import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class BotController {

    @PostMapping("/bot")
    public String showBot(@RequestParam("botName") String botName,
                          @RequestParam("channel") String channel,
                          @RequestParam("oauth") String oauth,
                          Model model) {

        TwitchConfiguration config = new TwitchConfiguration();
        config.loadConfigFile(model);

        Twirk twirk = new TwirkBuilder(
                config.getChannel(),
                config.getBotName(),
                config.getOauth())
                .setVerboseMode(true)
                .build();
        try {
            twirk.connect();
            System.out.println("Connected!");
        }
        catch (IOException e) {
            System.out.println("IOException when connecting.");

        }
        catch (InterruptedException e) {
            System.out.println("Connection interrupted.");
        }
        finally {
            twirk.close();
        }
        return "bot";
    }
}
