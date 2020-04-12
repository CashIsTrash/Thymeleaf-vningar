package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    private List<String> contactList = new ArrayList<>();

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model){
        model.addAttribute("contacts",contactList);
        return "contact-list";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam(name = "contact")String contact){
        if (!contact.isEmpty()){
            contactList.add(contact);
        }
        return "redirect:/contact";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}

