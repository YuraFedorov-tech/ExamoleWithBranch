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
@EnableCaching
@EntityScan(basePackages = "ru.yura")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
