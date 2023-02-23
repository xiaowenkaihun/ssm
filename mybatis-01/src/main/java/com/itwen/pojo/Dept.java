package com.itwen.pojo;

import java.util.List;

public class Dept {
    private int deptId;
    private String name;

    private List<Emp> emps;

    public Dept() {
    }

    public Dept(int deptId, String name, List<Emp> emps) {
        this.deptId = deptId;
        this.name = name;
        this.emps = emps;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}
