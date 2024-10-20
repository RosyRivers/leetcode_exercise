import java.util.Scanner;

public class sinkGudao {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
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
            for (int j = 0; j < m; j++) {
                if (gudao[0][j] == 1) dfs(gudao, 0, j);
                if (gudao[n - 1][j] == 1) dfs(gudao, n - 1, j);
            }
            for (int i = 1; i < n - 1; i++) {
                if (gudao[i][0] == 1) dfs(gudao, i, 0);
                if (gudao[i][m - 1] == 1) dfs(gudao, i, m - 1);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m - 1; j++) {
                    if (gudao[i][j] == 2) gudao[i][j] = 1;
                    else if (gudao[i][j] == 1) gudao[i][j] = 0;
                    System.out.printf("%d ", gudao[i][j]);
                }
                if (gudao[i][m - 1] == 2) gudao[i][m - 1] = 1;
                else if (gudao[i][m - 1] == 1) gudao[i][m - 1] = 0;
                System.out.println(gudao[i][m - 1]);
            }
        }

    }

    public static void dfs(int[][]gudao, int x, int y) {
        // 2表示与边缘接壤的陆地
        gudao[x][y] = 2;
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            if (x_ne < 0 || y_ne < 0 || x_ne >= gudao.length || y_ne >= gudao[0].length) continue;
            if (gudao[x_ne][y_ne] == 1) dfs(gudao, x_ne, y_ne);
        }
    }
}
