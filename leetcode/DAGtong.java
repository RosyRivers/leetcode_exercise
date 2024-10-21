import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class DAGtong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] matrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            matrix[in.nextInt() - 1][in.nextInt() - 1] = 1;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> hasVisited = new HashSet<>();
        queue.offer(0);
        hasVisited.add(0);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int i = 0; i < n; i++) {
                if (hasVisited.contains(i)) continue;
                if (matrix[curNode][i] == 1) {
                    queue.offer(i);
                    hasVisited.add(i);
                }
            }
        }
        if (hasVisited.size() == n) 
            System.out.println(1);
        else System.out.println(-1);
    }
}
