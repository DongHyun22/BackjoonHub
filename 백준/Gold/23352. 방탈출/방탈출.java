import java.io.*;
import java.util.*;

public class Main {
    static int n, m, maxLength, answer;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0)
                    bfs(i, j);
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int startx, int starty) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // x, y, 길이

        boolean[][] visited = new boolean[n][m];
        int start = map[startx][starty];
        int end = -1;
        int length = 0;

        queue.add(new int[]{startx, starty, 0});
        visited[startx][starty] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                if (lx >= 0 && lx < n && ly >= 0 && ly < m && map[lx][ly] != 0 && !visited[lx][ly]) {
                    queue.add(new int[]{lx, ly, temp[2] + 1});
                    visited[lx][ly] = true;
                    if (length < temp[2] + 1) {
                        length = temp[2] + 1;
                        end = map[lx][ly];
                    } else if (length == temp[2] + 1) {
                        end = Math.max(end, map[lx][ly]);
                    }
                }
            }
        }
        if (end == -1) {
            if (maxLength == 0 && length == 0)
                answer = Math.max(answer, start * 2);
        } else {
            if (maxLength < length) {
                maxLength = length;
                answer = start + end;
            } else if (maxLength == length) {
                answer = Math.max(answer, start + end);
            }
        }
    }
}