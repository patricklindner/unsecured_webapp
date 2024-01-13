package org.group7.unsecured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
public class TestController {

    @GetMapping
    public String securedResource() {
        return "This is secured content";
    }


    @PostMapping
    public void postForm(@RequestBody String privateData) {
        System.out.println(privateData);
    }

}
