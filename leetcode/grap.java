import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class grap {
    static List<Integer> path;
    static List<List<Integer>> result;
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph = new int[n + 1][n + 1];
            for (int i = 0; i < m; i++) {
                int node1 = in.nextInt();
                int node2 = in.nextInt();
                graph[node1][node2] = 1;
            }
            path = new ArrayList<>();
            result = new ArrayList<>();
            path.add(1);
            dfs(graph, 1);
        }
        if (result.isEmpty()) System.out.println(-1);
        else {
            for (List<Integer> pa : result) {
                for (int i = 0; i < pa.size() - 1; i++) {
                    System.out.printf("%d ",pa.get(i));
                }
                System.out.println(pa.get(pa.size() - 1));
            }
        }
        return;

    }

    public static void dfs(int[][] graph,int n) {
        if (n == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i < graph[n].length; i++) {
            if (graph[n][i] == 1) {
                path.add(i);
                dfs(graph, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
