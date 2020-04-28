package com.codeday;
//关羽过关斩三将，输入四个人的武力值（大于0小于50），若超过界限需要重新输入，关羽的武力值x，将士武力值为y，满足（x-y）^2+(x-y)+41 若为素数则关羽获胜，若关羽三次获胜输出 WIN，若失败则输出失败的将领序号（第几关）。
//
//        输入格式：
//        四个人的武力值
//
//        输出格式：
//        WIN或者失败将领的序号
//
//        输入样例：
//
//
//        40 20 30 20
//        输出样例：
//        WIN

import java.util.Scanner;

public class Code359 {
    //输入和进行界限判断
    public static int[] judge(){
        int[] strength=new int[4];//存放武力值数组
        Scanner s=new Scanner(System.in);
        for (int i = 0; i <4 ; i++) {
          int info=s.nextInt();
          if ((info<=0)||(info>=50)){
              System.out.println("越界，请重新输入！");
              info=s.nextInt();
          }
          strength[i]=info;
            System.out.println(strength[i]);
        }
        s.close();
        return strength;
    }
    //判断是否为素数
    public static boolean isSu(int value){
        boolean is=true;
        if (value==1){
            return false;
        }
        if(value==2){
            return true;
        }
        if (value%2==0){
            return false;
        }
        for (int i = 3; i <value ; i+=2) {
            if (i!=value && value%i==0){//可以被除本身外的其他数整除
                is=false;
            }
        }
        return is;
    }
    //进行比赛
    public static void match(int[] strength){
        for (int i = 1; i <strength.length ; i++) {
            int value=(strength[0]-strength[i])*2+(strength[0]-strength[i])+41;
            if (isSu(value)&&i==(strength.length-1)){//比赛三次且第三次的值为素数
                System.out.println("WIN");
            }
            if (!isSu(value)){
                System.out.println(i);
                break;
            }
        }
    }
    public static void main(String args[]){
       int[] strength=judge();
       match(strength);
    }
}
