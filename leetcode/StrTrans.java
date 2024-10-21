import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StrTrans {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String begin = in.next();
        String end = in.next();
        ArrayList<String> dir = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dir.add(in.next());
        }
        HashSet<String> hasVisit = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        hasVisit.add(begin);
        map.put(begin, 1);
        while (!queue.isEmpty()) {
            String curString = queue.poll();
            if (stringDistant(curString, end) == 1) {
                System.out.println(map.get(curString) + 1);
                break;
            }
            // 查询邻接节点
            for (int i = 0; i < dir.size(); i++) {
                // 判断下一个节点是否被遍历
                if (hasVisit.contains(dir.get(i))) continue;
                // 判断下一个节点是不是当前节点的邻接节点
                if (stringDistant(curString, dir.get(i)) == 1) {
                    queue.offer(dir.get(i));
                    hasVisit.add(dir.get(i));
                    map.put(dir.get(i), map.get(curString) + 1);
                }
            }

        } 
    }

    public static int stringDistant(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                res ++;
        }
        return res;
    }
}
