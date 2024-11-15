import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == '1') {
                    bfs(i, j);
                }
            }
        }

        int size = pq.size();
        System.out.println(size);
        for(int i = 0; i < size; i++) {
            System.out.println(pq.poll());
        }

    }

    public static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                if(lx >= 0 && lx < n && ly >= 0 && ly < n && !visited[lx][ly] && map[lx][ly] == '1') {
                    queue.add(new int[] {lx, ly});
                    visited[lx][ly] = true;
                    count++;
                }
            }
        }

        pq.add(count);
    }
}
