package org.group7.unsecured;

import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/secured")
public class TestController {

    @PostMapping
    public void postForm(@RequestParam String privateData) {
        System.out.println(privateData);
    }

}
