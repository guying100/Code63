package com.codeday;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//输入N个员工，每个员工输出ID号，上班时间，下班时间，
//        第一行输出最早去的员工的ID和上班时间
//        第二行输出最迟走的员工的ID和下班时间
//        第三行输出工作最久的员工的ID和上班时间
//
//        输入样例：
//        ID100001 07:00:00 17:00:00
//        ID100002 08:00:00 18:00:00
//        ID100003 09:00:00 21:00:00
//
//        输出样例：
//        OPEN:ID100001, 07:00:00
//        CLOSE:ID100003, 21:00:00
//        LONGEST WORK TIME ID:ID100003, 09:00:00
public class Code360 {
    //输入员工的信息函数
    public static List<Worker> info() throws ParseException {
        List<Worker> workers=new ArrayList<Worker>();
        SimpleDateFormat sdft=new SimpleDateFormat("HH:mm:ss");
        Worker w1=new Worker("ID100001", sdft.parse("07:00:00"), sdft.parse("17:00:00"));
        Worker w2=new Worker("ID100002", sdft.parse("08:00:00"), sdft.parse("18:00:00"));
        Worker w3=new Worker("ID100003", sdft.parse("09:00:00"), sdft.parse("21:00:00"));
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        return workers;
    }
    //交换
    public static void swap(Worker newW,List<Worker> workers,int j){
        newW= workers.get(j+1);
        workers.set(j+1,workers.get(j));
        workers.set(j,newW);
    }    //上班时间的排序
    public static void startpai(List<Worker> workers){
        Worker newW=null;
        for (int i = 0; i < workers.size()-1; i++) {
            for (int j = 0; j < workers.size()-1-i; j++) {
                if (workers.get(j).getStart().after(workers.get(j+1).getStart())) {//交换 按上班时间从早到晚排序
                   swap(newW,workers,j);
                }
            }
        }
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
//        第一行输出最早去的员工的ID和上班时间
        System.out.println("OPEN:"+workers.get(0).getId()+", "+dateFormat.format(workers.get(0).getStart()));
    }
    //下班时间的排序
    public static void endpai(List<Worker> workers){
        Worker newW=null;
        for (int i = 0; i < workers.size()-1; i++) {
            for (int j = 0; j < workers.size()-1-i; j++) {
                if (workers.get(j).getEnd().after(workers.get(j+1).getEnd())) {//交换 按上班时间从早到晚排序
                    swap(newW,workers,j);
                }
            }
        }
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm:ss");
//        第二行输出最迟走的员工的ID和下班时间
        System.out.println("CLOSE:"+workers.get(workers.size()-1).getId()+", "+dateFormat.format(workers.get(workers.size()-1).getEnd()));
    }
    //工作时间的排序
    public static void workLong(List<Worker> workers){
        Worker newW=null;
        for (int i = 0; i < workers.size()-1; i++) {//冒泡排序
            for (int j = 0; j < workers.size()-1-i; j++) {
                if ((workers.get(j).getEnd().getTime()-workers.get(j).getStart().getTime())>=(workers.get(j).getEnd().getTime()-workers.get(j).getStart().getTime())) {//交换 按上班时间从早到晚排序
                   swap(newW,workers,j);
                }
            }
        }
        SimpleDateFormat sdft=new SimpleDateFormat("HH:mm:ss");
//         第三行输出工作最久的员工的ID和上班时间
        System.out.println("LONGEST WORK TIME ID:"+workers.get(0).getId()+", "+sdft.format(workers.get(0).getStart()));
    }
    public static void main(String args[]) throws ParseException {
        List<Worker> workers=info();
        startpai(workers);
        endpai(workers);
        workLong(workers);
    }
}
class Worker{
    private String id;//员工id
    private Date start;//上班时间
    private Date end;//下班时间

    public Worker(String id, Date start, Date end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}