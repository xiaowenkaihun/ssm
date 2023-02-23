package com.itwen.pojo;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/16 17:40
 * 文件描述：
 */
public class Clazz {
    private Integer cid;
    private String name;

    private List<Student> students;

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Clazz() {
    }

    public Clazz(Integer cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
