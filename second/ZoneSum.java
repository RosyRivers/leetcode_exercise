import java.util.Scanner;

public class ZoneSum {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
            }
            int[] proSum = new int[n];
            for (int i = 1; i < proSum.length; i++) {
                proSum[i] = arr[i - 1] + proSum[i - 1];
            }
            while (in.hasNextInt()) {
                int left = in.nextInt();
                int right = in.nextInt();
                int sum = proSum[right] - proSum[left] + arr[right];
                System.out.println(sum);
            }
        }
    }
}
