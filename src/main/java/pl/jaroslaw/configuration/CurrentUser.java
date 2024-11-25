package pl.jaroslaw.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final pl.jaroslaw.model.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.jaroslaw.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.jaroslaw.model.User getUser() {return user;}
}
