package app.isa.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long sericalVersionUID = 1L;

    private String token;
    private final UserDetails principle;

    public TokenBasedAuthentication(UserDetails principle, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principle = principle;
    }

    public String getToken() {return token;}

    public void setToken(String token) {this.token = token;}

    @Override
    public boolean isAuthenticated() {return true;}

    @Override
    public Object getCredentials() {return token;}

    @Override
    public Object getPrincipal() {
        return principle;
    }

}
