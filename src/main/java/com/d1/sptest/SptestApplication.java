package com.d1.sptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptestApplication.class, args);
    }
@GetMapping("/")
    public String index(){
        return "OK";
}

}