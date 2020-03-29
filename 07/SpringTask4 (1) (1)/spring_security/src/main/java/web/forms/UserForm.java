package web.forms;

import lombok.Data;
import web.model.Role;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

/*
 *
 *@Data 19.03.2020
 *@autor Fedorov Yuri
 *@project spring_security
 *
 */
@Data
public class UserForm {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private List<Role> roles;
    private Role role;
    private String roles2;
}
