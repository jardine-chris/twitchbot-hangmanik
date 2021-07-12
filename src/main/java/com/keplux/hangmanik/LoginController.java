package com.keplux.hangmanik;

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
        try (InputStream is = new FileInputStream("src/main/resources/static/config.properties")) {
            Properties prop = new Properties();
            prop.load(is);

            String botName = prop.getProperty("botName");
            String channel = prop.getProperty("channel");
            String oauth = prop.getProperty("oauth");

            model.addAttribute("botName", botName);
            model.addAttribute("channel", channel);
            model.addAttribute("oauth", oauth);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "login";
    }
}
