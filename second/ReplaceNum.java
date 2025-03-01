import java.util.Scanner;

public class ReplaceNum {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            char[] s = in.nextLine().toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                if (s[i] <= '9' && s[i] >= '0') {
                    stringBuilder.append("number");
                }
                else stringBuilder.append(s[i]);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
