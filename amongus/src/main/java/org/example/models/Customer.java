package org.example.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


@Data
@Setter
@Getter
@Entity
@Table(name = "CUSTOMER" )
@Builder
@AllArgsConstructor
@NoArgsConstructor //이걸 안 적었구나
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerNo")
    private Long id;

    //PK가 아닌 아이디, 비밀번호의 아이디
    @Column(unique = true, name = "Customerid", nullable = false)
    private String Customerid;
    @Column(name = "CustomerPassword", nullable = false)
    private String CustomerPassword;
    @Column(name = "CustomerName", nullable = false)
    private String CustomerName;
    @Column(name = "PhoneNumber", nullable = false)
    private String PhoneNumber;
    @Column(unique = true, name = "Email", nullable = false)
    private String Email;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : role.split(",")) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return Customerid;
    }
    @Override
    public String getPassword(){
        return CustomerPassword;
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
