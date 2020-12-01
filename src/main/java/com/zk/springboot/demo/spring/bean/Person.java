package com.zk.springboot.demo.spring.bean;
//@PropertySource(value = {"classpath:person.properties"})
//@ConfigurationProperties(prefix = "person")

/**
 * 不管@Bean所在的类是否有@Configuration注解，都可以将@Bean修饰的方法注册到spring容器
 * @Configuration注解修饰的类，spring会通过cglib产生一个代理对象，并且拦截@Bean修饰的方法，可以确保一些bean是单例（总结参考路人甲java）
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

}
