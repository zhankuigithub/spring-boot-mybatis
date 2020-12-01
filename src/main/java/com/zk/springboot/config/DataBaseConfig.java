package com.zk.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DataBaseConfig {

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//
//        String path;
//        String env = System.getenv("ENV");
//        if ("development".equals(env)) {
//            path = new DevEnvProvider().configDir() + "/application.yml";
//        } else {
//            path = new ProdEnvProvider().configDir() + "/application.yml";
//        }
//
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        yaml.setResources(new FileSystemResource(path));
//        configurer.setProperties(yaml.getObject());
//        return configurer;
//    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
