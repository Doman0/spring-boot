package com.doman.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: Doman
 * @Date: 2020/4/17 Resource
 */
@Configuration
@ConfigurationProperties(prefix = "com.doman.opensource")
@PropertySource(value = "classpath:resource.properties")
@Data
public class Resource {
    private String name;
    private String website;
    private String language;
}
