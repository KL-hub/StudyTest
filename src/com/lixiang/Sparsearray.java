package com.lixiang;
/**
 * 稀疏数组的压缩存储
 */
public class Sparsearray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0 表示没有棋子，  1表示黑子    2 表篮子
        int chessArr[][]=new int [11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        System.out.println("原始的二维数组");
        for(int [] arr: chessArr){
            for(int i :arr){
                System.out.print("\t"+i);
            }
            System.out.println();
        }

        //将二维数组转换为稀疏数组
        //1、遍历原始数组得到非0的个数
        int sum=0;
        for (int i=0;i<11;i++){
            for (int j = 0; j <11; j++) {
                if(chessArr[i][j] !=0){
                    sum++;
                }
            }
        }
        //创建对应得稀疏数组
        int a=0;
        int sparse [][] =new int [sum+1][3];
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr[i][j]  != 0){
                    a++;
                    sparse[a][0]=i;
                    sparse[a][1]=j;
                    sparse[a][2]=chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int i = 0; i <sparse.length ; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparse[i][0],sparse[i][1],sparse[i][2]);
            
        }

        //稀疏数组的恢复为二维数组
        int arr2[][]=new int [sparse[0][0]][sparse[0][1]];
        for (int i = 1; i <= sparse[0][2]; i++) {
            arr2[sparse[i][0]][sparse[i][1]]=sparse[i][2];
        }
        System.out.println("输出原始的二维数组");
        for (int i = 0; i <arr2.length ; i++) {
            for (int j = 0; j < arr2.length; j++) {
                System.out.printf("%d\t",arr2[i][j]);
            }
            System.out.println();
        }
    }
}
