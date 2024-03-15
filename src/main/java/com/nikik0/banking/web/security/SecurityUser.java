package com.nikik0.banking.web.security;

import com.nikik0.banking.domain.model.Client;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
public class SecurityUser implements UserDetails{

    private final UUID id;
    private final String username;
    private final String password;
    private final Collection<SimpleGrantedAuthority> authorities;

    public SecurityUser(final Client user){
        this(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
        this.authorities.add(mapToGrantedAuthority("ROLE_USER"));
    }

    private SimpleGrantedAuthority mapToGrantedAuthority(String role) {
        return new SimpleGrantedAuthority(role);
    }

    private SecurityUser(
            final UUID id,
            final String username,
            final String password
    ){
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = new ArrayList<>();
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
