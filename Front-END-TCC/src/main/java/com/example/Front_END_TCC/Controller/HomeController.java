package com.example.Front_END_TCC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome"; // retorna o template welcome.html
    }
}
