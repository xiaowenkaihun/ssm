package com.itwen.pojo;

public class Emp {
    private Integer empId;
    private String name;
    private int age;
    private String gender;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer empId, String name, int age, String gender, Dept dept) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
