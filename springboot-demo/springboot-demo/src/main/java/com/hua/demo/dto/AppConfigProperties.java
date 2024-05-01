package com.hua.demo.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 配置类
 */
@Validated
@Data
@ConfigurationProperties(prefix = "app")
@Component
public class AppConfigProperties {
//    @NotEmpty(message = "配置文件配置必须要配置[app.id]属性")
    private String id;
    private String name;
}
