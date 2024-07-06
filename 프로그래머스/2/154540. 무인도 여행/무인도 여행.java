import java.util.*;

class Solution {
    static int n;
    static int m;
    static char[][] map;
    static ArrayList<Integer> list;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        list = new ArrayList<>();
        visited = new boolean[n][m];
        
        
        for(int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        
        if(list.isEmpty()) {
            list.add(-1);
        }
           
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int sum = 0;
        
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        sum += map[x][y] - '0';
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                if(lx >= 0 && lx < n && ly >= 0 && ly < m && map[lx][ly] != 'X' && !visited[lx][ly]) {
                    queue.add(new int[] {lx, ly});
                    visited[lx][ly] = true;
                    sum += map[lx][ly] - '0';
                }
            }
        }
        return sum;
    }
}