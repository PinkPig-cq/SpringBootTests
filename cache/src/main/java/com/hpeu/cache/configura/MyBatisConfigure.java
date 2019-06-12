package com.hpeu.cache.configura;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MyBatisConfigure {
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
