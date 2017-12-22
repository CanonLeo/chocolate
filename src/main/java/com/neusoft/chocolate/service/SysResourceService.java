package com.neusoft.chocolate.service;

import java.util.List;
import java.util.Map;

public interface SysResourceService {
    List<Map<String, Object>> findByRoleName(String roleName);
}
