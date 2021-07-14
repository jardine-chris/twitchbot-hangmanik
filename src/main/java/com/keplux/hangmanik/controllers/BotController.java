package com.keplux.hangmanik.controllers;

import com.gikk.twirk.Twirk;
import com.gikk.twirk.TwirkBuilder;
import com.keplux.hangmanik.Bot;
import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class BotController {

    @PostMapping("/bot")
    public String showBot(@RequestParam Map<String,String> params,
                          ModelMap model) {

        // Create the configuration file from the posted parameters.
        TwitchConfiguration config =
                new TwitchConfiguration.TwitchConfigurationBuilder()
                .botName(params.get("botName"))
                .channel(params.get("channel"))
                .oauth(params.get("oauth"))
                .setConfig();

        Bot bot = new Bot(config);
        try {
            bot.connect();
        }
        catch (IOException e) {
            System.out.println("IOException when connecting.");

        }
        catch (InterruptedException e) {
            System.out.println("Connection interrupted.");
        }
        finally {
            bot.close();
        }
        return "bot";
    }
}
