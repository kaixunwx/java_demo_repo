package com.wukaixun.gaoji.ioanli.toupiaoxitong;

public class Student implements Comparable<Student>{
    private long sid;
    private String name;
    private int vote;

    public Student(long sid, String name, int vote) {
        this.sid = sid;
        this.name = name;
        this.vote = vote;
    }

    public long getSid() {
        return sid;
    }

    public int getVote() {
        return vote;
    }

    public String getName() {
        return name;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return String.format("【sid】%s 【年龄】%s 【票数】%s", this.sid, this.name, this.vote);
    }

    @Override
    public int compareTo(Student stu) {
        return stu.vote - this.vote;
    }
}
