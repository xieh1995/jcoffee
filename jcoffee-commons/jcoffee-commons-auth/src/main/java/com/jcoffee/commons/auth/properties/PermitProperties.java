package com.jcoffee.commons.auth.properties;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置需要放权的url白名单
 *
 * @author zlt
 */
@Setter
@Getter
public class PermitProperties {
    /**
     * 监控中心和swagger需要访问的url
     */
    private static final String[] ENDPOINTS = {
            "/api/oauth/**",
            "/actuator/**",
            "/*/v2/api-docs",
            "/swagger/api-docs",
            "/swagger-ui.html",
            "/swagger-resources/**",
            "/webjars/**",
            "/druid/**"
    };

    /**
     * 设置不用认证的url
     */
    private String[] httpUrls = {};

    /**
     * 设置认证后不需要判断具体权限的url，所有登录的人都能访问
     */
    private String[] menusPaths = {};

    public String[] getUrls() {
        if (httpUrls == null || httpUrls.length == 0) {
            return ENDPOINTS;
        }
        List<String> list = new ArrayList<>();
        for (String url : ENDPOINTS) {
            list.add(url);
        }
        for (String url : httpUrls) {
            list.add(url);
        }
        return list.toArray(new String[list.size()]);
    }
}
