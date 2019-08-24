/**
 * 对于一个有N个整数元素的一维数组，找出它的子数组（数组中下标连续的元素组成的数组）之和的最大值。
 * 1）数组：{ 1, -2, 3,5, -3, 2 }，结果是：8
 * 2）数组：{ 0, -2, 3, 5, -1, 2 }，结果是：9
 * 3）数组：{ -9, -2,-3, -5, -3 }，结果是：-2
 */
public class MaxSum {
    public static  int max(int a,int b){
        return a>b?a:b;
    }
    public static int maxSum(int [] array){
        int n = array.length;
        int[] start = new int[n];
        int[] all = new int[n];
        all[n - 1] = start[n - 1] = array[n - 1];
        for(int i = n - 2; i >= 0;i--) {
            start[i] = max(array[i], array[i] + start[i + 1]);
            all[i] = max(start[i], all[i + 1]);
        }
        return all[0];


    }

    public static void main(String[] args) {
        int[] x1 = { 1, -2, 3, 5,-3, 2 };
        int[] x2 = { 0, -2, 3, 5,-1, 2 };
        int[] x3 = { -9, -2, -3,-5, -3 };
        System.out.println(maxSum(x1));   // 8

    }

}
