package ru.yura.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

/*
 *
 *@Data 04.04.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

@Controller
public class UserControllerOld {

    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "check")
    public String loginsPage() {
        return "crudfForWork";
    }

    final private
    UserService userService;

    public UserControllerOld(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "admin/admin")
    public String getAdminPanel(ModelMap modelMap, Authentication authentication) {
      //  modelMap.addAttribute("user", authentication.getPrincipal());
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("users", userService.findAll());
        System.out.println("   @GetMapping(value = \"admin/admin\")   CLIENTT");
        return "crud";
    }

    @GetMapping(value = "user")
    public String seeUser(ModelMap modelMap, Authentication authentication) {
       // modelMap.addAttribute("user", authentication.getPrincipal());
        modelMap.addAttribute("user", new User());
        return "seeUser";
    }
}
