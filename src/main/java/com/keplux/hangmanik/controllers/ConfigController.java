package com.keplux.hangmanik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Controller
public class ConfigController {

    @RequestMapping("/config")
    public String config(Model model) {


        return "config";
    }
}
