package ru.yura.web.model;
/*
 *
 *@Data 04.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Accessors(chain = true)
@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Long id;

    private String firstName;


    private List<Role> roles = new ArrayList<>();

    public void addRoles(Role role) {
        roles.add(role);
    }

    public void removeRoles(Role role) {
        roles.remove(role);
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }


    private String lastName;


    private Integer age;


    private String email;


    private String password;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public void setAuthorities(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
