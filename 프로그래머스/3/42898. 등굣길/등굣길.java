import java.util.*;

class Solution {
    static int n;
    static int m;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int[][] map;
    static int answer;
    public int solution(int m, int n, int[][] puddles) {
        this.n = n;
        this.m = m;
        
        map = new int[n][m];
        
        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        for(int i = 0; i < n; i++) {
            if(map[i][0] == -1)
                break;
            map[i][0] = 1;
        }
        for(int i = 0; i < m; i++) {
            if(map[0][i] == -1)
                break;
            map[0][i] = 1;
        }
        
        map[0][0] = 1;
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == -1 || map[i-1][j] == -1 && map[i][j-1] == -1)
                    continue;
                
                if(map[i-1][j] != -1 && map[i][j-1] != -1)
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                else if(map[i-1][j] == -1)
                    map[i][j] = map[i][j-1];
                else if(map[i][j-1] == -1)
                    map[i][j] = map[i-1][j];
                    
            }
        }
        
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }System.out.println();
        // }
        
        answer = map[n-1][m-1];
        return answer;
    }
    // public void bfs() {
    //     ArrayDeque<int[]> q = new ArrayDeque<>();
    //     q.add(new int[]{0, 0});
    //     while(!q.isEmpty()) {
    //         int[] temp = q.poll();
    //         for(int i = 0; i < 2; i++) {
    //             int lx = temp[0] + dx[i];
    //             int ly = temp[1] + dy[i];
    //             if(lx >= 0 && lx < n && ly >= 0 && ly < m && map[lx][ly] != -1) {
    //                 map[lx][ly] = (map[lx][ly] + map[temp[0]][temp[1]]) % 1000000007;
    //                 q.add(new int[]{lx, ly});
    //             }
    //         }
    //     }
    // }
}