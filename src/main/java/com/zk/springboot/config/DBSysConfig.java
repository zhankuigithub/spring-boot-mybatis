package com.zk.springboot.config;

import com.zk.springboot.db.sys.mapper.DBSysMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackageClasses = {DBSysMapper.class}, sqlSessionFactoryRef = "dbSysSqlSessionFactory")
public class DBSysConfig {

    @Bean("dbSysDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db-sys")
    public DataSource getDb1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dbSysSqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("dbSysDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:db/sys/*.xml"));
        return bean.getObject();
    }

    @Bean("dbSysSqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("dbSysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
