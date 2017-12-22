package com.neusoft.chocolate.security;

import com.neusoft.chocolate.entity.SysUser;
import com.neusoft.chocolate.security.entity.SecurityUser;
import com.neusoft.chocolate.service.SysUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private SysUserService sysUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.findByName(username);
        if (sysUser == null){
            log.error("用户名：" + username + "不存在！");
            throw new UsernameNotFoundException("用户名：" + username + "不存在！");
        }
        SecurityUser securityUser = new SecurityUser(sysUser);

        return securityUser;
    }
}
