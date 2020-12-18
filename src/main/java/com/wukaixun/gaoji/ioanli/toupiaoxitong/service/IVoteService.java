package com.wukaixun.gaoji.ioanli.toupiaoxitong.service;

import com.wukaixun.gaoji.ioanli.toupiaoxitong.Student;

public interface IVoteService {
    public boolean inc(long sid);
    public Student[] getData();
    public Student[] result();
}
