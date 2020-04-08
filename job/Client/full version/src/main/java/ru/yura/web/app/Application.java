package ru.yura.web.app;
/*
 *
 *@Data 07.04.2020
 *@autor Fedorov Yuri
 *@project Bootstrap3.1.3
 *
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import java.util.List;


@ComponentScan(basePackages = "ru")
//@EnableJpaRepositories(basePackages = "ru")
//@EnableRetry
@EnableCaching
//@EnableHystrix
@EntityScan(basePackages = "ru.yura")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
  //      UserService userService = ctx.getBean(UserService.class);
//        User user = userService.findModelByName("2@2.ru");
//        System.out.println(user.getId() + " public static void main(String[] args) { " + user);
//
//        List<User> users = userService.findAll();
//        System.out.println("users -" + users);
//
////        User user3 = userService.delete(userService.findModelByName("e3@3e.ru"));
////        System.out.println("user3 -" + user3);
//
////        User user4=userService.add(new User().setEmail("111111111111"),459L);
////        System.out.println(user4);
//
//        Long[]id={458L,459L, 456L, 463L};
//        User user5=userService.update(user.setFirstName("2"), id);
//        System.out.println(user5);






    }

}
