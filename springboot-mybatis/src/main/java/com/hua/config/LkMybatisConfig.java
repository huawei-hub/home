package com.hua.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages ="com.hua.mapper.lk",sqlSessionFactoryRef = "lkSqlSessionFactory")
public class LkMybatisConfig {

    @Bean("lkDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.lk")
    public DataSource fkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "lkSqlSessionFactory")
    public SqlSessionFactory fkSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/lk/*Mapper.xml"));
        bean.setDataSource(fkDataSource());
        bean.setVfs(SpringBootVFS.class);
        Properties properties = new Properties();
        properties.setProperty("log-impl", "org.apache.ibatis.logging.stdout.StdOutImpl");
        bean.setConfigurationProperties(properties);

        //开启sql日志打印
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    @Bean("lk")
    public SqlSessionTemplate fkSqlSessionTemplate(
            @Qualifier("lkSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
