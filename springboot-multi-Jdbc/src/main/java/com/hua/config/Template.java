package com.hua.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Template {

    @Bean("fkData")
    @ConfigurationProperties(prefix = "spring.fk.datasource")
    public DataSource fkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("fk")
    public JdbcTemplate fkTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(fkDataSource());
        return jdbcTemplate;
    }

    @Bean("lkData")
    @ConfigurationProperties(prefix = "spring.lk.datasource")
    public DataSource lkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("lk")
    public JdbcTemplate lkTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(lkDataSource());
        return jdbcTemplate;
    }
}
