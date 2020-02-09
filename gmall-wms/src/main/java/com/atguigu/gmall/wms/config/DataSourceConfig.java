package com.atguigu.gmall.wms.config;
import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

  /*  @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource hikariDataSource(@Value("${spring.datasource.url}")String url) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        return hikariDataSource;
    }*/

    /**
     * 需要将 DataSourceProxy 设置为主数据源，否则事务无法回滚
     *
     * @param hikariDataSource The HikariDataSource
     * @return The default datasource
     */

    /**
     *
     * @param url
     * @param username
     * @param password
     * @param driverClassName
     * @return
     */
    @Primary
    @Bean("dataSource")
    public DataSource dataSource(@Value("${spring.datasource.url}")String url,
                                 @Value("${spring.datasource.username}")String username,
                                 @Value("${spring.datasource.password}")String password,
                                 @Value("${spring.datasource.driver-class-name}")String driverClassName) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(url);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setDriverClassName(driverClassName);
        return new DataSourceProxy(hikariDataSource);
    }
}

