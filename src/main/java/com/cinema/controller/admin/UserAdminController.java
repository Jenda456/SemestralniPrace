package com.cinema.controller.admin;


import com.cinema.entity.User;
import com.cinema.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {


    private UserService userService;

    public UserAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<User> users = userService.findAll();

        theModel.addAttribute("users", users);

        return "users/admin/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        User user = new User();

        theModel.addAttribute("user", user);

        return "users/admin/user-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {

        //Movie movie = movieService.findById(theId);
        User user = new User(1,"Jan","Novak","email@adad.com");
        theModel.addAttribute("user", user);

        return "users/admin/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        System.out.println("saving movie: " + user.toString());

        return "redirect:/admin/user/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {

        System.out.println("deleting user: " + theId);

        return "redirect:/admin/user/list";

    }
}
