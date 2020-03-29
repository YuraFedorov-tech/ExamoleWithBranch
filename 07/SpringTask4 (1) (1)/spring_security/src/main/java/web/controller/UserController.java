package web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.forms.UserForm;
import web.model.Role;
import web.model.User;
import web.security.securityDitel.UserDetailesImpl;
import web.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    final private
    UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/user";
        }
        return "login";
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "hello")
    public String getHello() {
        return "hello";
    }


    @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {

        UserDetailesImpl ud = (UserDetailesImpl) authentication.getPrincipal();
        User user = (ud.getUser());
        modelMap.addAttribute("user", user);
        return "seeUser";
    }

    @PostMapping(value = "admin/add")
    public String addUser(UserForm uf) {
        String role = uf.getRole().getAuthority();

        List<Role> roles = Arrays.asList(new Role(role));
        User user = new User().setFirstName(uf.getFirstName())
                .setLastName(uf.getLastName()).setAge(uf.getAge())
                .setPassword(uf.getPassword()).setEmail(uf.getEmail());
        userService.add(user);
        return "redirect:/admin/admin";
    }

    @GetMapping(value = "admin/admin")
    public String getAdminPanel(ModelMap modelMap, Authentication authentication) {
        UserDetailesImpl ud = (UserDetailesImpl) authentication.getPrincipal();
        User user = (ud.getUser());
        modelMap.addAttribute("user", user);
        List<User> users = userService.findAll();
        modelMap.addAttribute("users", users);
        System.out.println(users);
        return "crud";
    }

    @PostMapping(value = "admin/update")
    public String postUpdateUser(UserForm uf) {
        String role = uf.getRole().getAuthority();
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(role));
        User user2 = userService.findById(uf.getId());
        User user = new User().setFirstName(uf.getFirstName())
                .setLastName(uf.getLastName()).setAge(uf.getAge())
                .setPassword(uf.getPassword()).setEmail(uf.getEmail())
                .setId(uf.getId());
        userService.update(user);
        return "redirect:/admin/admin";
    }

    @PostMapping(value = "admin/delete")
    public String deleteCar(@RequestParam(required = false, name = "idDelete") Long id) {
        userService.delete(id);
        return "redirect:/admin/admin";
    }
}