package com.xuanxue.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Jackson配置类
 * 配置JSON序列化时使用东八区时间
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@Configuration
public class JacksonConfig {

    /**
     * 配置ObjectMapper使用东八区时间
     * 
     * @param builder Jackson对象映射构建器
     * @return 配置好的ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        
        objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        
        return objectMapper;
    }
}

