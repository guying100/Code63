package com.codeday;

public class Code3 {
    private static int[][] next=new int[][]{
            {1,2},{1,-2},{-1,2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1},
    };//马儿可以走的8个下一步点
    private static int[][] book;
    private static int[][] a;//用来记录路径信息
    private static int n,m;//棋盘的行列数
    private static int count=0;//统计有多少种走法
    public static void main(String args[]){
        n=5;m=5;//棋盘的行列数
        int x=0,y=0;//马儿的初始点
        book=new int[n][m];//记录是否被访问过
        a=new int[n][m];//记录路径，即第几步
        book[x][y]=1;//初始化最初点被访问过
        dfs(x,y,1);//调用函数，(0,0) step=1
        System.out.println(count);
    }
    private static void dfs(int x,int y,int step){
        a[x][y]=step;
        //截止条件
        if (step==n*m){//表示已经遍历到最后一个棋位
            count++;
        }
        int tx=0,ty=0;
        for (int i = 0; i <8 ; i++) {
            tx=x+next[i][0];
            ty=y+next[i][1];
            //筛选
            if (tx<0||tx>=n||ty<0||ty>=m){//判断下一步要走的坐标是否在棋盘上，条件表示不在
                continue;//跳出本次循环
            }
            if (book[tx][ty]==0){
                book[tx][ty]=1;
                dfs(tx,ty,step+1);//继续遍历下一个点
                book[tx][ty]=0;
            }
        }
    }


    }


