
import java.util.Scanner;

/**
 * 54.replace-number
 */
/**
 * Replacenum
 */
public class Replacenum {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String input = in.nextLine();
            String result = replacenum(input);
            System.out.println(result);
        }
    }

    public static String replacenum(String s) {
        String num = "number";
        char[] res = s.toCharArray();
        int len = res.length;
        for (int i = 0; i < res.length; i++) {
            if (res[i] <= 57 && res[i] >= 48) {
                len += 5;
            }
        }
        char[] result = new char[len];
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] <= 57 && res[i] >= 48) {
                for (int k = 0; k < 6; k++) {
                    result[j] = num.charAt(k);
                    j++;
                }
            }
            else {
                result[j] = res[i];
                j++;
            }
        }
        return new String(result);
    }
}
