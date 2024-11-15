package springboot.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.springbootdemo.model.User;
import springboot.springbootdemo.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String addUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        Optional<User> user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit-update";
    }

    @PostMapping("/user-update")
    public String editUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}