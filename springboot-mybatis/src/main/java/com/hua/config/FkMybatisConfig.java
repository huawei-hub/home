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

@Configuration
@MapperScan(basePackages ="com.hua.mapper.fk",sqlSessionFactoryRef = "fkSqlSessionFactory")
public class FkMybatisConfig {

    @Bean("fkDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.fk")
    public DataSource fkDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "fkSqlSessionFactory")
    public SqlSessionFactory fkSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/fk/*Mapper.xml"));
        bean.setDataSource(fkDataSource());
        bean.setVfs(SpringBootVFS.class);
        //开启sql日志打印
        org.apache.ibatis.session.Configuration configuration =
                new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
        bean.setConfiguration(configuration);
        return bean.getObject();
    }

    @Primary
    @Bean("fk")
    public SqlSessionTemplate fkSqlSessionTemplate(
            @Qualifier("fkSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
