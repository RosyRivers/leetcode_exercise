import java.util.Scanner;

public class maxSqGudao {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int sq = 0;
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] gudao = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    gudao[i][j] = in.nextInt();
                }
            }
            // 将行边缘的陆地改为海洋
            
            for (int j = 0; j < m; j++) {
                if (gudao[0][j] == 1) dfs(gudao, 0, j);
                if (gudao[n - 1][j] == 1) dfs(gudao, n-1, j);
            }
            // 将列边缘的陆地改为海洋

            for (int i = 1; i < n - 1; i++) {
                if (gudao[i][0] == 1) dfs(gudao, i, 0);
                if (gudao[i][m - 1] == 1) dfs(gudao, i, m-1);

            }


            // 寻找孤岛的面积
            sq = 0;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (gudao[i][j] == 1) {
                        dfs(gudao, i, j);
                    }
                }
            }
        }
        System.out.println(sq);
        

    }

    public static void bfs(int[][] gudao, int x, int y) {

    }
    public static void dfs(int[][] gudao, int x, int y) {
        gudao[x][y] = 0;
        sq ++;
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            if (x_ne < 0 || y_ne < 0 || x_ne >= gudao.length || y_ne >= gudao[0].length) continue;
            if (gudao[x_ne][y_ne] == 1) {
                dfs(gudao, x_ne, y_ne);
            }
        }
    }
}
