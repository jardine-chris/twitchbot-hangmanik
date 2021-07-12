package com.keplux.hangmanik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class HangmanIkApplication {

    public static void main(String[] args) {
        SpringApplication.run(HangmanIkApplication.class, args);
    }

}
