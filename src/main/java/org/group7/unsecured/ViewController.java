package org.group7.unsecured;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/secured")
    public String secured() {
        return "secured";
    }

    @PostMapping("/secured")
    public String secret(@RequestParam String privateData) {
        System.out.println("Processing private data received from user [" + privateData + "]");
        return "secured";
    }

}