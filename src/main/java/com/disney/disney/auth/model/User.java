package com.disney.disney.auth.model;


import com.disney.disney.model.BaseClass;
import io.swagger.annotations.ApiModel;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ApiModel("Model User")
public class User  extends BaseClass implements UserDetails {
    
    @NotNull
    protected String password;
    @Email(message = "mail not valid")
    @NotNull
    protected String email;   
    @NotBlank
    @Size(min = 10, max = 20, message = "First Name must be between 10 and 20 characters long")    
    protected String firstName;
    @NotBlank
    @Size(min = 10, max = 20, message = "Last Name must be between 10 and 20 characters long")
    protected String lastName;    
   

    @CreationTimestamp
    protected Timestamp timestamp;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    protected List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
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

