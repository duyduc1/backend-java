package baitap1.baitap1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @GetMapping("/introduc")
    public String index(){
        return "index";
    }
}
