package com.doman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.doman.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.doman", "org.n3r.idworker"})
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class Springboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class, args);
    }

}
