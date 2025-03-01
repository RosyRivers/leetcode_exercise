import java.util.Scanner;

public class daoyuLen {
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
            int len = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (daoyu[i][j] == 1) {
                        // 找到边的条件
                        // 邻居是水域
                        for (int k = 0; k < dir.length; k++) {
                            int i_ne = i + dir[k][0];
                            int j_ne = j + dir[k][1];
                            if (i_ne < 0 ||j_ne < 0 || i_ne >= n || j_ne >= m || daoyu[i_ne][j_ne] == 0)
                                len ++;
                        }
                    }
                }
            }
            System.out.println(len);
        }
    }
}
