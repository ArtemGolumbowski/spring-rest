
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.User;
import com.agolumbowski.spring.rest.quiz_rest.service.impl.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agolu
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public Page getUsers(Model model, @RequestParam(defaultValue = "0") int page) {
        
        return userService.getAllUsers(page);
        
    }

    @PostMapping("/deleteuser")
    public String deleteUser(long userId) {
        userService.delete(userId);
        return "redirect:/users";
    }

    @GetMapping("/edituser")
    public String editUser(long userId, Model model) {
        User user = userService.read(userId);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/edituser")
    public String editUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

}
