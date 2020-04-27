package com.codeday;

public class Code63 {
    public static int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        //如果起始位置和终点位置为1，直接返回0
        if(arr[0][0] == 1 || arr[m-1][n-1] == 1) return 0;
        //如果m == 1，判断第m-1行是不是有1，有1直接返回0，否则返回1
        if(m == 1) {
            for(int j = 1;j<n;j++) {
                if(arr[0][j] == 1)
                    return 0;
            }
            return 1;
        }
        //如果n == 1，判断第n-1列是不是有1，有1直接返回0，否则返回1
        if(n == 1) {
            for(int i = 1;i < m;i++) {
                if(arr[i][0] == 1)
                    return 0;
            }
            return 1;
        }
        //定义和输入数组arr一样大小的数组，作为判断
        int[][] array = new int[m][n];
        for(int j = 1;j<n;j++) {
            //判断arr[0][j]是否等于1，如果不等于1，那么array[0][j]等于0，如果等于1，
            //从j列开始到j<n，array[0][j]全部赋值为0
            if(arr[0][j] == 0) {
                array[0][j] = 1;
            }else {
                for(int k = j;k<n;k++) {
                    array[0][k] = 0;
                }
                break;
            }
        }
        for(int i = 1;i<m;i++) {
            //判断arr[i][0]是否等于1，如果不等于1，那么array[i][0]等于0，如果等于1，
            //从i行开始到i<m，array[i][0]全部赋值为0
            if(arr[i][0] == 0) {
                array[i][0] = 1;
            }else {
                for(int k = i;k<m;k++) {
                    array[k][0] = 0;
                }
                break;
            }
        }
        for(int i = 1;i<m;i++) {
            for(int j = 1;j<n;j++) {
                //如果arr[i][j] == 1,array = 0,否则array[i][j] = array[i-1][j] + array[i][j - 1]
                if(arr[i][j] == 0) {
                    array[i][j] = array[i-1][j] + array[i][j - 1];
                }
            }
        }
        //返回数组array最后一个数
        return array[m-1][n-1];
    }
    public static void main(String args[]){
          int[][] path={
                          {0,0,0},
                          {0,1,0},
                          {0,0,0}
                        };
        int ways=uniquePathsWithObstacles(path);
        System.out.println(ways);

    }


}
