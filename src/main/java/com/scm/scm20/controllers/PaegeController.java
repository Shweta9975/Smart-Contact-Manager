package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class PaegeController {


    @RequestMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page handler");

        // sending data to view
        model.addAttribute("name","Substring Technologies");
        model.addAttribute("YoutubeChannel","Learn Code with Shweta");
        model.addAttribute("GithubRepository","https://github.com/Shweta9975/");
          return "home";
    }


    //about route
   
   @RequestMapping("/about") 
    public String aboutPage(Model model){

        model.addAttribute("isLogin", false);
        System.out.println("about page loading...");
        return "about";
    }
      
    //services
 
    @RequestMapping("/services") 
    public String servicesPage(){

        System.out.println("services page loading...");
        return "services";
    }
      
   // contact page
   @GetMapping("/contact")
   public String contact() {
    
       return new String("contact");
   }
   
   //login page
   @GetMapping("/login")
   public String login() {
       return new String("login");
   }
  
   //register
    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
