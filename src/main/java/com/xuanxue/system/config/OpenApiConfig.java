package com.xuanxue.system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI/Swagger配置类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Configuration
public class OpenApiConfig {

    /**
     * 创建OpenAPI配置
     * 
     * @return OpenAPI配置对象
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("中国玄学系统API")
                        .description("提供八字计算和六爻占卜功能的API接口文档")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("wbguan2")
                                .email("wbguan2@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}

