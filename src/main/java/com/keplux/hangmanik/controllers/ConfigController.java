package com.keplux.hangmanik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @RequestMapping("/config")
    public String config() {
        return "config";
    }
}
