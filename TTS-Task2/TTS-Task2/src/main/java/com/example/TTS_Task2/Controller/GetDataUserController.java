package com.example.TTS_Task2.Controller;

import com.example.TTS_Task2.Entity.User;
import com.example.TTS_Task2.Service.GetDataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GetDataUserController {

    @Autowired
    private GetDataUserService getDataUserService ;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users" , getDataUserService.getAllUsers());
        return "home";
    }

    @GetMapping("/home/{id}")
    public String getUserById(@PathVariable("id") Long id , Model model) {
        User user = getDataUserService.getUserById(id);
        model.addAttribute("user" , user);
        return "user-detail";
    }

    @GetMapping("/edit/{id}")
    public String FormEditUser(@PathVariable("id") Long id, Model model) {
        User user = getDataUserService.getUserById(id);
        model.addAttribute("user" , user);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String UpdateUser(@PathVariable("id") Long id , @ModelAttribute User user, Model model) {
        getDataUserService.updateUser(id,user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String DeleteUser(@PathVariable("id") Long id){
        getDataUserService.deleteUser(id);
        return "redirect:/home";
    }
}
