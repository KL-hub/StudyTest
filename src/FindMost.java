/**
 * 给一个数组，其中有一个重复元素占半数以上，找出这个元素
 *
 */
public class FindMost {
    public static <T> T find(T[] x){
        T temp = null;
        for(int i = 0, nTimes = 0; i< x.length;i++) {
            if(nTimes == 0) {
                temp= x[i];
                nTimes= 1;
            }
            else {
                if(x[i].equals(temp)) {
                    nTimes++;
                }
                else {
                    nTimes--;
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        String[]strs = {"kiss","hello","world","hello","hello"};
        System.out.println(find(strs));

    }

}
