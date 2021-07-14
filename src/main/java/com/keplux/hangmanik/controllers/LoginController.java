package com.keplux.hangmanik.controllers;

import com.keplux.hangmanik.TwitchConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(Model model) {
        TwitchConfiguration config = new TwitchConfiguration();
        config.loadConfigFile(model);

        return "login";
    }
}
