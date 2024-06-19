package org.products.backendquestion1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Backendquestion1Application {

    public static void main(String[] args) {

        SpringApplication.run(Backendquestion1Application.class, args);


    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
