package com.zk.springboot.demo.spring.config;

import com.zk.springboot.demo.spring.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Test {

    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);


    public static void main(String[] args) {
        String osName = applicationContext.getEnvironment().getProperty("os.name");
        System.out.println("当前系统为：" + osName);
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }

}
