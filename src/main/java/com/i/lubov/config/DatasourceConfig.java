/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.config;

import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.AbstractDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据源开关配置，默认处于开启状态
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Configuration
@AutoConfigureBefore(SpringBootConfiguration.class)
@ConditionalOnProperty(name = "spring.shardingsphere.enabled", havingValue = "ture")
public class DatasourceConfig {

    @Bean
    public DataSource dataSource() {
        return new NoopDataSource();
    }

    /**
     * 生成空的数据源拦截Druid数据的启动过程
     * {@link SpringBootConfiguration}
     */
    public static class NoopDataSource extends AbstractDataSource {

        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }
    }
}
