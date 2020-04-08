package ru.yura.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {


    final private
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "auth/findUserByName/{name}")
    public User findUserByName(@PathVariable String name) {
        System.out.println(" @PostMapping(value = \"admin/findUserByName\")");
        User user = userService.findModelByName(name);
        return user;
    }
    @GetMapping(value = "admin/findUserById/{id}")
    public User findUserById(@PathVariable Long id) {
        System.out.println(" @PostMapping(value = \"admin/findUserById\")");
        User user = userService.findById(id);
        return user;
    }
    @GetMapping(value = "admin/admin")
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @PostMapping(value = "admin/delete")
    public User deleteUser(@RequestBody User user) {
        System.out.println("    @PostMapping(value = \"admin/delete\")");
        userService.delete(userService.findModelByName(user.getEmail()));
        return user;
    }



    @PostMapping(value = "admin/add/{id}")
    public User addUser(@RequestBody User user, @PathVariable Long id, HttpServletRequest req) {
        System.out.println(" @PostMapping(value = \"admin/add\")");
        userService.add(user, id);
        return user;
    }

    @PostMapping(value = "admin/update")
    public User postUpdateUser( @RequestBody User user) {
        System.out.println(" @PostMapping(value = \"admin/update\")");
        User userUpdate = userService.update(user);
        return userUpdate;
    }
//    @PostMapping(value = "admin/add")
//    public User addUser(User user, @RequestParam(required = false, name = "role_id") Long id, HttpServletRequest req) {
//        System.out.println(" @PostMapping(value = \"admin/add\")");
//
//        userService.add(user, id);
//        return user;
//    }
//


    @PostMapping(value = "admin/upsdfdate")
    public User postUpdatsdfeUser(User user, @RequestParam(required = false, name = "role_id") Long[] ids) {
        System.out.println(" @PostMapping(value = \"admin/update\")");
        User userUpdate = userService.update(user);
        return userUpdate;
    }


}