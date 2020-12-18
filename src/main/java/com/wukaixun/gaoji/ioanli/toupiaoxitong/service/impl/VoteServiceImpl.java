package com.wukaixun.gaoji.ioanli.toupiaoxitong.service.impl;

import com.wukaixun.gaoji.ioanli.toupiaoxitong.Student;
import com.wukaixun.gaoji.ioanli.toupiaoxitong.service.IVoteService;

import java.util.Arrays;

public class VoteServiceImpl implements IVoteService {
    public static VoteServiceImpl VOTE_SERVICE_IMPL = new VoteServiceImpl();

    private VoteServiceImpl(){};

    public static VoteServiceImpl getInstance() {
        return VOTE_SERVICE_IMPL;
    }

    private Student[] students = new Student[]{
            new Student(1, "张三", 0),
            new Student(2, "李四", 0),
            new Student(3, "王五", 0)
    };

    @Override
    public boolean inc(long sid) {
        for (int x = 0; x < this.students.length; x++) {
            if (sid == this.students[x].getSid()) {
                this.students[x].setVote(this.students[x].getVote() + 1);  // 票数增长
                return true;
            }
        }
        return false;
    }

    @Override
    public Student[] getData() {
        return this.students;
    }

    @Override
    public Student[] result() {
        Arrays.sort(this.students);
        return this.students;
    }
}
