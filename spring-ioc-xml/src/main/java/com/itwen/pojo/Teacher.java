package com.itwen.pojo;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/16 17:00
 * 文件描述：
 */
public class Teacher implements Person{
    private Integer tid;
    private String name;

    public Teacher() {
    }

    public Teacher(Integer tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
