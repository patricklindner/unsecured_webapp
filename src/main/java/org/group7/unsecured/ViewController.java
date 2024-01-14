package org.group7.unsecured;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/secured")
    public String secured(Model model, Authentication authentication) {
        model.addAttribute("username", authentication.getPrincipal().toString());
        return "secured";
    }

    @PostMapping("/secured")
    public RedirectView secret(@RequestParam String privateData) {
        System.out.println("Processing private data received from user [" + privateData + "]");
        return new RedirectView("secured");
    }

}