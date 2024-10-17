import java.util.ArrayDeque;
import java.util.Scanner;

public class maxSqDaoyu {
    private static boolean[][] visited;
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
                int m = in.nextInt();
                int[][] daoyu = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        daoyu[i][j] = in.nextInt();
                    }
                }
                visited = new boolean[n][m];
                int result = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (daoyu[i][j] == 1 && !visited[i][j]) {
                            visited[i][j] = true;
                            // int res = dfs(daoyu, i, j);
                            int res = bfs(daoyu, i, j);
                            result = Math.max(res, result);
                        }
                    }
                }
                System.out.println(result);
        }
    }

    public static int bfs(int[][] daoyu, int x, int y) {
        int sq = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] local = queue.poll();
            x = local[0];
            y = local[1];
            for (int i = 0; i < dir.length; i++) {
                int x_ne = x + dir[i][0];
                int y_ne = y + dir[i][1];
                if (x_ne < 0 || y_ne < 0 || x_ne >= daoyu.length || y_ne >= daoyu[0].length) continue;
                if (daoyu[x_ne][y_ne] == 1 && !visited[x_ne][y_ne]) {
                    visited[x_ne][y_ne] = true;
                    queue.offer(new int[]{x_ne, y_ne});
                    sq ++;
                }
            }
        }
        return sq;
    }

    public static int dfs(int[][] daoyu, int x, int y) {

        // sq 表示该节点及其邻接节点的陆地面积
        int sq = 1;
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            // 超出地图边界
            if (x_ne < 0 || y_ne < 0 || x_ne >= daoyu.length || y_ne >= daoyu[0].length) continue;
            if (daoyu[x_ne][y_ne] == 1 && !visited[x_ne][y_ne]) {
                visited[x_ne][y_ne] = true;
                sq += dfs(daoyu, x_ne, y_ne);
            }
        }
        return sq;

    }
}
