package com.keplux.hangmanik.controllers;

import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfigController {

    // When save button is pressed.
    @RequestMapping(value = "/", method = RequestMethod.POST, params = "save")
    public String save(@ModelAttribute("botName") String botName,
                       @ModelAttribute("channel") String channel,
                       @ModelAttribute("oauth") String oauth) {

        // Build new TwitchConfiguration object based on the model.
        TwitchConfiguration config =
                new TwitchConfiguration.TwitchConfigurationBuilder()
                        .botName(botName)
                        .channel(channel)
                        .oauth(oauth)
                        .setConfig();

        config.store(config);

        return "login";
    }

    // Load page and close button pressed.
    @RequestMapping("/config")
    public String config(Model model) {
        TwitchConfiguration config = new TwitchConfiguration();
        config.loadConfigFile(model);

        return "config";
    }
}
