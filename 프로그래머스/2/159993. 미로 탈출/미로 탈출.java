import java.util.*;

class Solution {
    static char[][] map;
    static int n;
    static int m;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean state;
    static int[] start = {0, 0};
    static int[] end = {0, 0};
    static int[] lever = {0, 0};
    static int first = Integer.MAX_VALUE;
    static int second = Integer.MAX_VALUE;
    
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            char[] c = maps[i].toCharArray();
            for(int j = 0; j < m; j++) {
                if(c[j] == 'S') {
                    save(start, i, j);
                }
                else if(c[j] == 'E') {
                    save(end, i, j);
                }
                else if(c[j] == 'L') {
                    save(lever, i, j);
                }
                map[i] = c;
            }
        }
        bfs(start[0], start[1]);
        if(first == Integer.MAX_VALUE)
            return -1;
        bfs(lever[0], lever[1]);
        if(second == Integer.MAX_VALUE)
            return -1;
        
        int answer = first + second;
        return answer;
    }
    public void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                
                if(lx >= 0 && lx < n && ly >= 0 && ly < m && !visited[lx][ly] && map[lx][ly] != 'X') {
                    char c = map[lx][ly];
                    if(!state && c == 'L') {
                        first = temp[2] + 1;
                        state = !state;
                        return;
                    }
                    else if(state && c == 'E') {
                        second = temp[2] + 1;
                        return;
                    }
                    
                    queue.add(new int[]{lx, ly, temp[2] + 1});
                    visited[lx][ly] = true;
                    
                }
            }
        }
    }
    
    public void save(int[] arr, int i, int j) {
        arr[0] = i;
        arr[1] = j;
    }
    
}