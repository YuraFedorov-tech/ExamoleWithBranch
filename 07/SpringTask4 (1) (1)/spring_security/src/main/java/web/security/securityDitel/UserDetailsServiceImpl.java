package web.security.securityDitel;
/*
 *
 *@Data 20.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
 {
    private final UserService userService;

     public UserDetailsServiceImpl(UserService userService) {
         this.userService = userService;
     }

     @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users =userService.findAll();
        if(users==null){
            return null;
        }
        for( User user:users){
            if(user.getEmail().equals(email)){
                return new UserDetailesImpl(user);
            }
        }
        return null;
    }
}
