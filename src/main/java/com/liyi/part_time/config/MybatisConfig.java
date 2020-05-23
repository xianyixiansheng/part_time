package com.liyi.part_time.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration //代表这个类是一个配置类。
@MapperScan("com.liyi.part_time.dao")//扫描指定包下面所有的接口类，然后所有接口在编译之后会生成相应的接口实现类
public class MybatisConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
