package com.dk.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dk.model.User;
import com.dk.service.UserService;
 
@Controller
public class UserController {
     
//    private UserService userService;
//     
//    @Autowired(required=true)
//    @Qualifier(value="userService")
//    public void setUserService(UserService ps){
//        this.userService = ps;
//    }
//     
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String listUsers(Model model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("listUsers", this.userService.getUsers());
//        return "users";
//    }
//     
//    //For add and update user both
//    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User u){
//         
//        userService.SaveOrUpdateUser(u);
//         
//        return "redirect:/users";
//         
//    }
//     
//    @RequestMapping("/remove/{id}")
//    public String removeUser(@PathVariable("username") int id){
//         
//        this.userService.deleteUser(id);
//        return "redirect:/users";
//    }
//  
//    @RequestMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.userService.getUser(id));
//        model.addAttribute("listUsers", this.userService.getUsers());
//        return "users";
//    }
     
}