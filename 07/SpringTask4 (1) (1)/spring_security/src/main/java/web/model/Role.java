package web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.Set;


/*
 *
 *@Data 10.03.2020
 *@autor Fedorov Yuri
 *@project spring_mvc
 *
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor
@Entity

@Table(name = "roles_9")
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = -8186644851823152209L;

    @Id
    @Column(name = "ID_")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLE")
    private String role;


    public Role(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }


}