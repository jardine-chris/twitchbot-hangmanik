package com.keplux.hangmanik.controllers;

import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(Model model) {
        TwitchConfiguration config = new TwitchConfiguration();
        config.loadConfigFile(model);

        return "login";
    }
}
