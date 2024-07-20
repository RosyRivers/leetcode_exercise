
import java.util.Scanner;

public class rightxuan {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int k = Integer.parseInt(in.nextLine());
            String s = in.nextLine();
            if (k == s.length()) {
                System.out.println(s);
                return;
            }
            System.out.println(right(s, k));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public static String right(String s, int k) {
        char[] ori = s.toCharArray();
        char[] ma = new char[ori.length];
        int slow = 0;
        for (int i = ori.length - k; i >= 0; i++) {
            i = i % ori.length;
            ma[slow] = ori[i];
            slow ++;
            if (i == ori.length - k - 1) break;
        }
        return new String(ma);
    }
}
