import java.util.Scanner;

public class RightXuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String s = in.next();
        StringBuffer string = new StringBuffer();
        int begin = s.length() - k;
        for (; begin < s.length(); begin++) {
            string.append(s.charAt(begin));

        }
        for (int i = 0; i < s.length() - k; i++) {
            string.append(s.charAt(i));
        }
        System.out.println(string.toString());

    }
}
