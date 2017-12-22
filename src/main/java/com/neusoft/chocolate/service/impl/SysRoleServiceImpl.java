package com.neusoft.chocolate.service.impl;

import com.neusoft.chocolate.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Override
    public List<Map<String, Object>> findAll() {
        return null;
    }
}
