package com.keplux.hangmanik.controllers;

import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(Model model) {
        TwitchConfiguration config = new TwitchConfiguration();
        config.loadConfigFile(model);

        return "login";
    }
}
