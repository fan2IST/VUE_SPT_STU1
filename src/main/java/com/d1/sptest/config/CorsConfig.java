package com.d1.sptest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    private static final long MAX_AGE = 24 * 60 * 60;

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:8080");//源地址(目标地址)
        corsConfiguration.addAllowedHeader("*");//请求头
        corsConfiguration.addAllowedMethod("*");//请求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**",corsConfiguration);//对接口跨域配置
        return new CorsFilter(source);
    }

}
