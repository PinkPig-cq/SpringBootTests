package com.hpeu.jdbc.configure;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewFilter;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfigure {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控器的servlet
     * {@link StatViewServlet} 这个是Druid监控默认的servlet
     * 可以配置初始化参数 {@link com.alibaba.druid.support.http.ResourceServlet}
     * 如：loginUsername，loginPassword
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean StatViewServlet() {
        //配置StatViewServlet
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //初始化参数{@link ResourceServlet}
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        //不写默认允许所以
        map.put("allow", "");
        bean.setInitParameters(map);
        return bean;
    }

    /**
     * 配置Druid的监控器的filter
     * {@link WebStatFilter} 这个是Druid监控默认的filter
     * 可以配置初始化参数
     * 如：exclusions
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("*"));
        return bean;
    }
}
