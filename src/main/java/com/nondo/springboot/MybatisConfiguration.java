package com.nondo.springboot;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
public class MybatisConfiguration {

    @Bean
    @ConditionalOnMissingBean //当容器里没有该bean时创建该对象
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 设置mapper映射文件
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        //设置mapper映射文件
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperXml;
        try {
            mapperXml = resolver.getResources("classpath:mybatis/mapper/*.xml");
            sqlSessionFactoryBean.setMapperLocations(mapperXml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置别名包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.nondo.springboot.domain");
        return sqlSessionFactoryBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.nondo.springboot");
        return mapperScannerConfigurer;
    }
}
