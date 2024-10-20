import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class waterFlow {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] heights = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    heights[i][j] = in.nextInt();
                }
            }
            // 初始化两个二位boolean数组，代表两个边界
            boolean[][] pacific = new boolean[n][m];
            boolean[][] atlantic = new boolean[n][m];

            // 从左右边界出发进行DFS
            for (int i = 0; i < n; i++) {
                pacific[i][0] = true;
                dfs(heights, i, 0, pacific);
                atlantic[i][m - 1] = true;
                dfs(heights, i, m - 1, atlantic);
            }

            // 从上下边界出发进行DFS
            for (int j = 0; j < m; j++) {
                pacific[0][j] = true;
                dfs(heights, 0, j, pacific);
                atlantic[n - 1][j] = true;
                dfs(heights, n - 1, j, atlantic);
            }

            // 当两个边界二维数组在某个位置都为true时，符合题目要求
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (pacific[i][j] && atlantic[i][j]) {
                        res.add(Arrays.asList(i, j));
                    }
                }
            }

            // 打印结果
            for (List<Integer> list : res) {
                for (int k = 0; k < list.size(); k++) {
                    if (k == 0) {
                        System.out.print(list.get(k) + " ");
                    } else {
                        System.out.print(list.get(k));
                    }
                }
                System.out.println();
            }
        }
    }

    public static void dfs(int[][] heights, int x, int y, boolean[][] visited) {
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            if (x_ne < 0 || x_ne >= heights.length || y_ne < 0 || y_ne >= heights[0].length || visited[x_ne][y_ne]) continue;
            // 不满足水流入条件的直接返回
            if (heights[x_ne][y_ne] < heights[x][y]) continue;
            // 满足条件，设置为true，表示可以从边界到达此位置
            visited[x_ne][y_ne] = true;
            dfs(heights, x_ne, y_ne, visited);
        }
        // 遇到边界或者访问过的点，直接返回

        // 向下一层继续搜索
        
    }
}
