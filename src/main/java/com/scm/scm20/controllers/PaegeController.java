package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaegeController {


    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");

        // sending data to view
        model.addAttribute("name","Substring Technologies");
        model.addAttribute("YoutubeChannel","Learn Code with Shweta");
        model.addAttribute("GithubRepository","https://github.com/learncodewithdurgesh/");
          return "home";
    }
}
