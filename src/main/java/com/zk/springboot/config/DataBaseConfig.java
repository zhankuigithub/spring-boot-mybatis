package com.zk.springboot.config;

import com.zk.springboot.environment.impl.DevEnvProvider;
import com.zk.springboot.environment.impl.ProdEnvProvider;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class DataBaseConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {

        String path;
        String env = System.getenv("ENV");
        if ("development".equals(env)) {
            path = new DevEnvProvider().configDir() + "/application.yml";
        } else {
            path = new ProdEnvProvider().configDir() + "/application.yml";
        }

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new FileSystemResource(path));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }

}
