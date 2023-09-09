package com.lucascorp.smetilender.api.health;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smetilender")
public class HelloController {

    @GetMapping("/health")
    public String helth() {
        return "Teste OK";
    }
}
