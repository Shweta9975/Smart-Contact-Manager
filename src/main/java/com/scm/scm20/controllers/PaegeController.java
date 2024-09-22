package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm20.services.UserService;
import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;


@Controller
public class PaegeController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {

        UserForm userForm=new UserForm();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value="/do-register",method= RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){

        System.out.println("Processing registration");
        System.out.println(userForm);
        

        //UserForm --> user
       // save to database

        // userservice

     //  UserForm--> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic(
        // "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
        // .build();

        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
       // user.setEnabled(userForm.isEnabled());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75\")\r\n");
        user.setEnabled(true);
         User savedUser=userService.saveUser(user);
        System.out.println("user saved");
        return "redirect:/register";
    }

}
