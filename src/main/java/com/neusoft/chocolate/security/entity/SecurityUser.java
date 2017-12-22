package com.neusoft.chocolate.security.entity;

import com.neusoft.chocolate.entity.SysRole;
import com.neusoft.chocolate.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

public class SecurityUser extends SysUser implements UserDetails {

    public SecurityUser(SysUser sysUser) {
        if (sysUser != null) {
            this.setId(sysUser.getId());
            this.setName(sysUser.getName());
            this.setEmail(sysUser.getEmail());
            this.setPassword(sysUser.getPassword());
            this.setTime(sysUser.getTime());
            this.setSysRoles(sysUser.getSysRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
