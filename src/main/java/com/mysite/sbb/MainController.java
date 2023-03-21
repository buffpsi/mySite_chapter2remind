package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/hello")
    @ResponseBody
    public String HelloOutPut() {
        return "hello! 여기 출렸했어요!";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/quenstion/list";

    }
}
