package com.neusoft.chocolate.service.impl;

import com.neusoft.chocolate.service.SysResourceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {
    @Override
    public List<Map<String, Object>> findByRoleName(String roleName) {
        return null;
    }
}
