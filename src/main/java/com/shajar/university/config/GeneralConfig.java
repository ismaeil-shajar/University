package com.shajar.university.config;

import com.shajar.university.common.filters.URIRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    @Bean
    public FilterRegistrationBean<URIRequestFilter> findRequestFilter(){
        FilterRegistrationBean<URIRequestFilter> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new URIRequestFilter());
        registrationBean.addUrlPatterns("/projects/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
