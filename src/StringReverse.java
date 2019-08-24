/**
 * 用递归实现字符串反转
 */
public class StringReverse {

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length()== 1) {
            return originStr;
        }
        System.out.println(originStr.substring(1)+"============="+originStr.charAt(0));
        return reverse(originStr.substring(1))+ originStr.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
