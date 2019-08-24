/**
 * 一个有n级的台阶，一次可以走1级、2级或3级，问走完n级台阶有多少种走法
 */
public class GoSteps {
    public static int countWays(int n) {
        if(n<0){
            return  0;
        }else if(n==0){
            return  1;

        }else {
            return  countWays(n-1)+countWays(n-2)+countWays(n-3);
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(6));

    }
}
