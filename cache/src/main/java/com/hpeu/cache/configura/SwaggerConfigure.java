package com.hpeu.cache.configura;

import com.fasterxml.classmate.ResolvedType;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.security.core.context;
import java.util.*;

/**
 * Swagger的配置文件
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    /**
     * 配置Swagger的摘要信息
     * @return
     */
    @Bean
    public Docket docket(){
        List<Parameter> operationParameters = new ArrayList<>();
        //构建一个Parameter
        Parameter parameter = new ParameterBuilder()
                .name("token")
                .parameterType("header")  //规定传的Token 为请求头   -> 参数2：query(做为普通参数传递进来)
                .modelRef(new ModelRef("String")) //
                .description("用户令牌") //描述
                .build();


        //如何获取全局的token
        //需要引入  spring-security 框架
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        operationParameters.add(parameter);


        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(operationParameters) //设置全局的参数，那么所有方法都可以不再需要填真个参数也能传
                .select()  //过滤，指定只对controller包下的 进行Swagger标注

                .build();
    }
}


