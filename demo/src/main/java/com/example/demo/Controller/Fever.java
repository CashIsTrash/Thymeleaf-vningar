package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Fever {

    @GetMapping("/fever-start")
    public String checkFever(){
        return "fever-start";
    }

    @PostMapping("/fever-check")
    public String contact(@RequestParam(name = "temperature")String temperature){
        boolean numeric = true;
        Integer num = 0;
        try {
            num = Integer.parseInt(temperature);
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if(numeric){
            if (num > 37) return "fever";
            if (num <= 37 && num > 35 ) return "healthy";
            if (num <= 35) return "hypothermia";
        }else{
            throw new NumberFormatException("Enter your temperature in number form");
        }
        return "fever-start";
    }
}

