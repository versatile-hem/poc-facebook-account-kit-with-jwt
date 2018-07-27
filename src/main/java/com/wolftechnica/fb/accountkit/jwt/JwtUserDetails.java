package com.wolftechnica.fb.accountkit.jwt;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails {

	private static final Log log = LogFactory.getLog(JwtUserDetails.class);
	
	private static final long serialVersionUID = -4057215308977509407L;
	
	private String userName;
    private String token;
    private String role;


    public JwtUserDetails(String userName, String token, String role) {
    	log.info("UserName : "+userName  +" | role: "+role);
        this.userName = userName;
        this.token= token;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	return Arrays.asList((GrantedAuthority) new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
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

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }


}
