package com.neusoft.chocolate.security;

import com.neusoft.chocolate.service.SysResourceService;
import com.neusoft.chocolate.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service(value = "mySecurityMetadataSource")
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysResourceService sysResourceService;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourceMap == null) {
            loadResourceDefine();
        }
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resURL);
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    @PostConstruct
    private void loadResourceDefine() {
        List<Map<String, Object>> list = sysRoleService.findAll();
        List<String> query = new ArrayList<String>();
        if (list != null && list.size() > 0) {
            for (Map<String, Object> sr : list) {
                Object value = sr.get("name");
                String name = String.valueOf(value);
                query.add(name);
            }
        }
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        for (String auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth);
            //List<Map<String,Object>> query1 = sResourceVODao.findByRoleName(auth);
            List<String> querys = new ArrayList<String>();
            List<Map<String, Object>> list1 = sysResourceService.findByRoleName(auth);
            if (list1 != null && list1.size() > 0) {
                for (Map<String, Object> map : list1) {
                    Object value = map.get("resource_string");
                    String url = String.valueOf(value);
                    querys.add(url);
                }
            }
            for (String res : querys) {
                String url = res;
            }

        }
    }
}
