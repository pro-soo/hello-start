package hello.hellostart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // welcome page
    @GetMapping("/")    // mapping 되는 것이 있으면 먼저 실행하고 없으면 static 실행
    public String home(){
        return "home";
    }
}
