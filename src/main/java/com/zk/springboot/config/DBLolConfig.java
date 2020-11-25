package com.zk.springboot.config;

import com.zk.springboot.db.lol.mapper.DBLolMapper;
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
@MapperScan(basePackageClasses = {DBLolMapper.class}, sqlSessionFactoryRef = "dbLolSqlSessionFactory")
public class DBLolConfig {

    @Bean("dbLolDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db-lol")
    public DataSource getDb1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("dbLolSqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("dbLolDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:db/lol/*.xml"));
        return bean.getObject();
    }

    @Bean("dbLolSqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("dbLolSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
