package com.springboot.app.SpringBootDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //GET HTTP METHOD
    @GetMapping("/Hello-World")
    public String helloWorld(){
        return "Hello world!";
    }
}

