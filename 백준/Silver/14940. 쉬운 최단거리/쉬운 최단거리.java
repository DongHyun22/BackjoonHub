import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int startx;
    static int starty;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startx = i;
                    starty = j;
                }
            }
        }

        bfs(startx, starty);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && answer[i][j] == 0) {
                    answer[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int lx = cur[0] + dx[i];
                int ly = cur[1] + dy[i];
                if(lx >= 0 && lx < n && ly >= 0 && ly < m && !visited[lx][ly] && map[lx][ly] == 1) {
                    answer[lx][ly] = cur[2] + 1;
                    visited[lx][ly] = true;
                    q.add(new int[]{lx, ly, cur[2] + 1});
                }
            }
        }
    }
}
