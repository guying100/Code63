package com.codeday;
//建立一个学生信息系统，输入学生信息，输出有挂科同学的信息，再按照平均成绩从高到低排序输出。
//        输入样例：
//        5
//        zhaoyi 70 80 90 240
//        qianer 65 32 77 174
//        sunsan 100 55 68 223
//        lisi 86 77 90 253
//        wangwu 100 59 66 225
//        输出样例：
//        *[qianer] 65 32 77
//        *[sunsan] 100 55 68
//        *[wangwu] 100 59 66
//        lisi 86 77 90
//        zhaoyi 70 80 90
//        wangwu 100 59 66
//        sunsan 100 55 68
//        qianer 65 32 77


import java.util.ArrayList;
import java.util.List;

public class Code354 {
    //获取学生的信息
    public  static List<Student> info(){
        List<Student> students=new ArrayList<Student>();
        Student s1=new Student("zhaoyi",70 ,80, 90, 240);
        Student s2=new Student("qianer", 65 ,32 ,77 ,174);
        Student s3=new Student("sunsan" ,100, 55 ,68 ,223);
        Student s4=new Student( "lisi", 86 ,77, 90, 253);
        Student s5=new Student("wangwu", 100 ,59 ,66 ,225);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        return students;
    }
    //判断学生的每一科成绩，并输出不及格学生的信息
    public static void judge(List<Student> students){
        for (int i = 0; i <students.size() ; i++) {
            Student s=students.get(i);
            if (s.getGrade1()<60||s.getGrade2()<60||s.getGrade3()<60){
                System.out.println("*["+s.getName()+"] "+s.getGrade1()+" "+s.getGrade2()+" "+s.getGrade3());
            }
        }
    }
    //学生成绩按平均成绩排序，然后从高到低排序
    public static void paixu(List<Student> students){
        Student newS=null;
        for (int i = 0; i < students.size()-1; i++) {
              for (int j = 0; j < students.size()-1-i; j++) {
                      if (students.get(j).getTotal() < students.get(j+1).getTotal()) {//交换
                         newS= students.get(j+1);
                         students.set(j+1,students.get(j));
                         students.set(j,newS);
                      }
              }
        }
        //输出排序后的学生信息
        for (int i = 0; i < students.size(); i++) {
            Student s=students.get(i);
            System.out.println(s.getName()+" "+s.getGrade1()+" "+s.getGrade2()+" "+s.getGrade3());
        }
    }
    public static void main(String args[]){
        List<Student> students=info();
        judge(students);
        paixu(students);
    }
}
class Student{
    private String name;
    private int grade1,grade2,grade3,total;

    public Student(String name, int grade1, int grade2, int grade3, int total) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade1() {
        return grade1;
    }

    public void setGrade1(int grade1) {
        this.grade1 = grade1;
    }

    public int getGrade2() {
        return grade2;
    }

    public void setGrade2(int grade2) {
        this.grade2 = grade2;
    }

    public int getGrade3() {
        return grade3;
    }

    public void setGrade3(int grade3) {
        this.grade3 = grade3;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
