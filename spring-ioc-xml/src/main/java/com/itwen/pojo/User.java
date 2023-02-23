package com.itwen.pojo;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/17 20:08
 * 文件描述：
 */
public class User {
    private Integer id; private String name; private Integer age;
    private String sex;

    public User() {

        System.out.println("生命周期1： 实例化，无参构造");
    }

    public User(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
        System.out.println("生命周期2：依赖注入");
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void initMethod(){
        System.out.println("生命周期3：初始化");
    }

    public void destroyMethod(){
        System.out.println("生命周期4：销毁");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
