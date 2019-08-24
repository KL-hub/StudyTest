import java.util.Arrays;

/**
 *有一个已经排好序的整数数组，其中存在重复元素，请将重复元素删除掉，例如，A= [1, 1, 2, 2, 3]，处理之后的数组应当为A= [1, 2, 3]
 */
public class RemoveDuplication {
    public  static  int[] removeSame(int [] arr){
        if(arr.length<=1) {
            return arr;
        }
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[index] != arr[i]){
                arr[++index]=arr[i];
            }
        }
        int[] b = new int[index + 1];
        System.arraycopy(arr, 0, b, 0, b.length);
        return arr;

    }
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3};
        a=removeSame(a);
        System.out.println(Arrays.toString(a));

    }
}
