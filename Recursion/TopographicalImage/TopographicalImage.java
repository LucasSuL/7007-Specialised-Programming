package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Lucas Su
 * @create 2023-08-01-19:28
 */
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class TopographicalImage {
    static String tData[];

    static boolean visited[][];
    static List<Integer> list = new ArrayList<>();
    static int count = 0;
    static int res = 0;

    public static boolean isValid(int a, int b, int x, int y) {
        // a,b is the new point waiting to be checked whether it's valid: 1-not out of boundary (this need to be at frontend)
        // 2-not higher than topo[x][y],
        // 3-not been visited before.
        return (a >= 0 && b >= 0 && a <= tData.length - 1 && b <= tData[0].length() - 1 && tData[a].charAt(b) <= tData[x].charAt(y) && !visited[a][b]);
    }

    public static void BFS(Pair pair) {
        count++;
        int x = pair.x;
        int y = pair.y;
        visited[x][y] = true;
        if (isValid(x - 1, y - 1, x, y)) BFS(new Pair(x - 1, y - 1));
        if (isValid(x - 1, y, x, y)) BFS(new Pair(x - 1, y));
        if (isValid(x - 1, y + 1, x, y)) BFS(new Pair(x - 1, y + 1));
        if (isValid(x, y - 1, x, y)) BFS(new Pair(x, y - 1));
        if (isValid(x, y + 1, x, y)) BFS(new Pair(x, y + 1));
        if (isValid(x + 1, y - 1, x, y)) BFS(new Pair(x + 1, y - 1));
        if (isValid(x + 1, y, x, y)) BFS(new Pair(x + 1, y));
        if (isValid(x + 1, y + 1, x, y)) BFS(new Pair(x + 1, y + 1));
    }


    public static int[] calcPeakAreas(String[] topoData) {
        tData = topoData;
        int y = tData.length;
        int x = tData[0].length();
        boolean localVisited [][] = new boolean[y][x];
        visited = localVisited;

        while (res < y * x) {
            // find current highest point
            int highX = 0, highY = 0;
            int max = -999;
            for (int i = 0; i < y; i++) {
                for (int i1 = 0; i1 < x; i1++) {
                    if (!visited[i][i1] && topoData[i].charAt(i1) > max) {
                        highY = i;
                        highX = i1;
                        max = topoData[i].charAt(i1);
                    }
                }
            }
            Pair pair = new Pair(highY, highX);

            BFS(pair);
            list.add(count);
            res += count;
            count = 0;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr =
                {
                        "............",
                        "....i..i....",
                        "....i..i....",
                        ".o..i..i..o.",
                        ".o........o.",
                        "..oooooooo..",
                        "............"
                };
        int[] res = calcPeakAreas(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
