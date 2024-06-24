import java.util.Scanner;

public class InputManager {
    public static void main(String[] args) {
        // var in = new Scanner(System.in);
        // int num = in.nextInt();
        // 输入数组
        // int[] nums = arrayproc(in);
    }

    public static int[] arrayproc(Scanner in)
    {
        String input = in.nextLine();
        String[] temp = input.split(" ");
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }

}


