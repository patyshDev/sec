package ru.snakesnake.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.snakesnake.crudapp.model.Role;
import ru.snakesnake.crudapp.model.User;
import ru.snakesnake.crudapp.service.RoleService;
import ru.snakesnake.crudapp.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> list = userService.listUsers();
        model.addAttribute("allUsers", list);
        return "all-users";
    }

    @GetMapping("/add")
    public String getUserForm(Model model) {
        model.addAttribute("listRole", roleService.listRoles());
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("addUser") User user,
                          @RequestParam(value = "newRole", required = false) String[] role) {
        user.setRoles(getAddRole(role));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("editUser", userService.getUserById(id));
        model.addAttribute("listRole", roleService.listRoles());
        return "user-edit-form";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("editUser") User user,
                             @RequestParam(value = "newRole", required = false) String[] role) {
        user.setRoles(getAddRole(role));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    private Set<Role> getAddRole(String [] role) {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < role.length; i++) {
            roleSet.add(roleService.getRoleByName(role[i]));
        }
        return roleSet;
    }
}
