import java.util.*;

class Solution {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] arr;
    static boolean flag;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
            findCorona(places[i]);
            if(flag)
                answer[i] = 0;
            else
                answer[i] = 1;
            
        }
        return answer;
    }
    
    public void findCorona(String[] s) {
        arr = new char[5][5];
        for(int i = 0; i < 5; i++) {
            arr[i] = s[i].toCharArray();
        }
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] == 'P') {
                    if(bfs(i, j)) {
                        flag = true;
                        return;
                    };
                }
            }
        }
        flag = false;
    }
    
    public boolean bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new int[] {x, y, 0});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                if(lx >= 0 && lx < 5 && ly >= 0 && ly < 5 && !visited[lx][ly] && temp[2] < 2) {
                    char c = arr[lx][ly];
                    visited[lx][ly] = true;
                    if(c == 'X') {
                        continue;
                    }
                    if(c == 'P') {
                        return true;
                    }
                    queue.add(new int[] {lx, ly, temp[2] + 1});
                }
                
            }
        }
        return false;
    }
}