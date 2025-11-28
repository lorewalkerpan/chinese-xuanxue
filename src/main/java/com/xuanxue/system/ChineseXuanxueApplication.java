package com.xuanxue.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * 中国玄学系统启动类
 * 
 * @author wbguan2
 * @date 2025-11-27
 */
@SpringBootApplication
public class ChineseXuanxueApplication {

    /**
     * 初始化时区为东八区（北京时间）
     */
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }

    /**
     * 应用程序入口
     * 
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(ChineseXuanxueApplication.class, args);
    }
}
