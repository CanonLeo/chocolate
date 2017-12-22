package com.neusoft.chocolate.service;

import com.neusoft.chocolate.entity.SysUser;

public interface SysUserService {

    SysUser findByName(String username);

}
