package com.wukaixun.gaoji.ioanli.toupiaoxitong.menu;

import com.wukaixun.gaoji.ioanli.toupiaoxitong.Student;
import com.wukaixun.gaoji.ioanli.toupiaoxitong.factory.Factory;
import com.wukaixun.gaoji.ioanli.toupiaoxitong.service.IVoteService;
import com.wukaixun.gaoji.ioanli.toupiaoxitong.util.InputUtil;

public class Menu {
    private IVoteService voteService = Factory.getInstance();

    public Menu(){
        this.vote();
    }
    public void vote(){
        Student[] students = this.voteService.getData();
        for(Student student: students){
            System.out.println(student.getSid() + ":" + student.getName() + " 目前选票:" + student.getVote());
        }
        int num = 10;
        while (num != 0){
            num = InputUtil.getInt("请输入投票人id(以数字0结束):");
            if(num != 0){
                if(!this.voteService.inc(num)){
                    System.out.println("输入选票无效！请输入正确选举人id");
                }
            }
        }
        System.out.println("最终投票结果:");
        students = this.voteService.result();
        System.out.println(students[0].getName() + "同学以" + students[0].getVote() + "票当选!");
    }

}
