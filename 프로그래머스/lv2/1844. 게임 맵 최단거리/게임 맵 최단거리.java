import java.util.*;
class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});
        loop:while(!(q.isEmpty())) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int dep = temp[2];
            for(int i = 0; i < 4; i++){
                int lx = x + dx[i];
                int ly = y + dy[i];
                if(lx == n-1 && ly == m-1){
                    answer = dep + 1;
                    break loop;
                }
                if(lx >= 0 && lx < n && ly >= 0 && ly < m && maps[lx][ly] == 1 && !visited[lx][ly]){
                    q.add(new int[]{lx, ly, dep+1});
                    visited[lx][ly] = true;
                }
            }
        }
        if(answer == 0) {
            answer = -1;
        }
        return answer;
    }
}