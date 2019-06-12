package com.hpeu.jdbc.configure;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的配置类
 */
@Configuration
public class MybatisConfigure {
    /**
     * 配置MyBatis 的规则
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        ConfigurationCustomizer configurationCustomizer = (configuration)->{
            configuration.setMapUnderscoreToCamelCase(true);
        };
        return configurationCustomizer;
    }
}
