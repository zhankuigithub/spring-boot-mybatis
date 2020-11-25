package com.zk.springboot.config;


import com.zk.springboot.db.mxd.mapper.DBMxdMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackageClasses = {DBMxdMapper.class}, sqlSessionFactoryRef = "dbMxdSqlSessionFactory")
public class DBMxdConfig {

    @Primary
    @Bean("dbMxdDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db-mxd")
    public DataSource getDb1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("dbMxdSqlSessionFactory")
    public SqlSessionFactory dbMxdSqlSessionFactory(@Qualifier("dbMxdDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:db/mxd/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean("dbMxdSqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("dbMxdSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
