package com.example.lastdance;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.FileNotFoundException;

@SpringBootApplication
public class LastDanceApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(LastDanceApplication.class, args);
    }
}
