package com.zk.springboot.demo.spring.config;


import com.zk.springboot.demo.spring.bean.Person;
import com.zk.springboot.demo.spring.bean.condition.LinuxCondition;
import com.zk.springboot.demo.spring.bean.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Conditional(WindowsCondition.class)
    @Bean(name = "bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person2() {
        return new Person("Linus", 48);
    }

}
