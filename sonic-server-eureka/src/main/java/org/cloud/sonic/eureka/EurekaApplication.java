package org.cloud.sonic.eureka;

import org.glassfish.jersey.servlet.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication  {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }


}