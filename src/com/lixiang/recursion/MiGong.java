package com.lixiang.recursion;

/**
 * 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        int [][]map =new  int [8][7];
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i <7 ; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[4][3]=1;
        map[4][4]=1;
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("走过的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public  static boolean setWay(int [][] map,int i,int j){
        if(map[6][5]==2){       //2表示通路
            return  true;
        }else{
            if(map[i][j]==0){   //表示这个点还没走过
                //按照下-右-上-左的策略走
                map[i][j]=2;       //假设该点可以走通
                if(setWay(map,i+1,j)){
                    return  true;
                }else  if(setWay(map,i,j+1)){
                    return  true;
                } else if(setWay(map,i-1,j)){
                    return  true;
                } else if(setWay(map,i,j-1)){
                    return  true;
                }else {
                    map[i][j]=3;        //3代表走不通
                }
            }else
                return false;
        }
        return false;
    }
}
