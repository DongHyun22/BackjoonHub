import java.util.*;

class Solution {
    static char[][] map;
    static int n;
    static int m;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int startx;
    static int starty;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }
        loop:for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'R') {
                    startx = i;
                    starty = j;
                    break loop;
                }
            }
        }
        
        bfs();
        // 멈추었을 때 그때의 방문기록만을 체크하여 bfs
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    
    public void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[] {startx, starty, 0});
        visited[startx][starty] = true;
        loop: while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int x = temp[0];
                int y = temp[1];
                while(true) {
                    int lx = x + dx[i];
                    int ly = y + dy[i];
                    if(lx >= 0 && lx < n && ly >= 0 && ly < m && map[lx][ly] != 'D') {
                        x = lx;
                        y = ly;
                    }
                    else {
                        break;
                    }
                }
                // 멈춤
                if(map[x][y] == 'G') {
                    answer = Math.min(answer, temp[2] + 1);
                    break loop;
                }
                if(!visited[x][y]) {
                    queue.add(new int[]{x, y, temp[2] + 1});
                    // System.out.println(x + " " + y + " " + temp[2]);
                    visited[x][y] = true;
                }
            }
        }
        
        
    }
}