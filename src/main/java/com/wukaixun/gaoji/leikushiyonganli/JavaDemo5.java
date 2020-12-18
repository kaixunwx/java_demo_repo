package com.wukaixun.gaoji.leikushiyonganli;

import java.util.Arrays;

/**
 * 学生信息排序
 * 按照成绩逆序排序，成绩相同的按照年龄正序排序
 *
 * @author wukaixun
 * @date 2020.10.21
 */
public class JavaDemo5 {
    public static void main(String[] args) {
        String input = "张三:24:98|李四:25:96|王五:22:96|凯勋:24:100";
        String[] result = input.split("\\|");
        Student students[] = new Student[result.length];
        for (int x = 0; x < result.length; x++) {
            String[] temp = result[x].split(":");
            students[x] = new Student(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
        }

//        Arrays.sort(students);
//        System.out.println(Arrays.toString(students));

        // 使用冒泡排序完成
        // 第一轮排序先按照成绩逆序排序
        for (int x = 0; x < students.length; x++) {
            for (int y = 0; y < students.length - 1 - x; y++) {
                if(students[y].getScore() < students[y+1].getScore()){
                    Student temp = students[y];
                    students[y] = students[y+1];
                    students[y+1] = temp;
                }
            }
        }
        // 第二轮排序按照相同成绩 年龄顺序排序
        for (int x = 0; x < students.length; x++) {
            for (int y = 0; y < students.length - 1 - x; y++) {
                if(students[y].getScore() == students[y+1].getScore()){
                    if(students[y].getAge() > students[y+1].getAge()){
                        Student temp = students[y];
                        students[y] = students[y+1];
                        students[y+1] = temp;
                    }
                }
            }
        }


        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student stu) {
        if (this.score < stu.score) {  // 逆序
            return 1;
        } else if (this.score > stu.score) {
            return -1;
        } else { // 正序
            return this.age - stu.age;
        }
    }

    @Override
    public String toString() {
        return String.format("[Student]姓名: %s, 年龄: %s, 成绩: %s + \n", this.name, this.age, this.score);
    }
}
