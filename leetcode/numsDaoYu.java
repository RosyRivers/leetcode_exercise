import java.util.ArrayDeque;
import java.util.Scanner;

public class numsDaoYu {

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
                    // 判断该节点是不是未遍历的陆地节点
                    if (daoyu[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        result ++;
                        //dfs(daoyu, i, j);
                        bfs(daoyu, i, j);
                    }
                }
            }
            System.out.println(result);
        }

    }

    public static void bfs(int[][] daoyu, int x, int y){
        // 加入陆地起始遍历节点，并遍历当前节点的周围节点
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            // 获取队列中的节点
            int[] local = queue.poll();
            x = local[0];
            y = local[1];
            // 遍历周围的节点
            for (int i = 0; i < dir.length; i++) {
                int x_ne = x + dir[i][0];
                int y_ne = y + dir[i][1];
                // 判断是否超出地图
                if (x_ne < 0 || x_ne >= daoyu.length || y_ne < 0 || y_ne >= daoyu[0].length) continue;
                // 判断下一个陆地节点是否未遍历
                if (daoyu[x_ne][y_ne] == 1 && !visited[x_ne][y_ne]) {
                    visited[x_ne][y_ne] = true;
                    queue.offer(new int[]{x_ne, y_ne});
                }
            }   
        }

    }

    public static void dfs(int[][] daoyu, int x, int y) {
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            // 判断是否遍历出地图
            if (x_ne < 0 || x_ne >= daoyu.length || y_ne < 0 || y_ne >= daoyu[0].length) continue;
            // 如果是否访问或者非陆地，则跳过
            if (daoyu[x_ne][y_ne] == 1 && !visited[x_ne][y_ne]) {
                visited[x_ne][y_ne] = true;
                dfs(daoyu, x + dir[i][0], y + dir[i][1]); 
            }
                
        }

    }
}