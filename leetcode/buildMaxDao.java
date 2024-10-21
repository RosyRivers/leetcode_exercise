
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * buildMaxDao
 */
public class buildMaxDao {
    private static int count;
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
            Map<Integer, Integer> sqDao = new HashMap<>();

            // 遍历所有未标记的陆地节点并记录面积
            int mark = 2;
            boolean isAllIsland = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 陆地节点
                    if (daoyu[i][j] == 0) isAllIsland = false;
                    if (daoyu[i][j] == 1) {
                        count = 0;
                        dfs(daoyu, i, j, mark);
                        sqDao.put(mark, count);
                        // 遍历完一个岛屿，编号＋1
                        mark ++;
                    }
                }
            }

            if (isAllIsland) {
                System.out.println(n * m);
                return;
            }
            // 定义一个HashSet，用来判断某一位置水四周是否存在不同标记编号的岛屿
            HashSet<Integer> set = new HashSet<>();
            // for (Map.Entry<Integer, Integer> entry : sqDao.entrySet()) {
            //     Integer key = entry.getKey();
            //     Integer value = entry.getValue();
            //     System.out.println("Key: " + key + ", Value: " + value);
            // }

            // 遍历所有的非陆地节点，并记录周边面积
            int result = 1;
            int res = result;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (daoyu[i][j] == 0) {
                        // 遍历周边节点，并记录面积
                        result = 1;
                        set.clear();
                        for (int k = 0; k < dir.length; k++) {
                            int inext = i + dir[k][0];
                            int jnext = j + dir[k][1];
                            if (inext < 0 || jnext < 0 || inext >= n || jnext >= m || daoyu[inext][jnext] == 0 || set.contains(daoyu[inext][jnext])) continue;
                            // System.out.println(daoyu[inext][jnext]);
                            result += (sqDao.get(daoyu[inext][jnext]));
                            set.add(daoyu[inext][jnext]);
                            if (res < result) res = result;
                        }
                    }
                }
            }
            System.out.println(res);
        }
        
    }

    public static void dfs(int[][] daoyu, int x, int y, int mark) {
        daoyu[x][y] = mark;
        count ++;
        for (int i = 0; i < dir.length; i++) {
            int x_ne = x + dir[i][0];
            int y_ne = y + dir[i][1];
            if (x_ne < 0 || y_ne < 0 || x_ne >= daoyu.length || y_ne >= daoyu[0].length) continue;
            if (daoyu[x_ne][y_ne] == 1) {
                dfs(daoyu, x_ne, y_ne, mark);
            }
        }

    }
}