import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][][] visited;
    static int n;
    static int[][] dp;
    
    public int solution(int[][] board) {
        n = board.length;
        visited = new boolean[n][n][4];
        dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(board);
        
        return dp[n-1][n-1];
    }
    
    public void bfs(int[][] board) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // x, y, x방향, y방향, 직선도로, 코너
        int[] start = new int[] {0, 0, 0, 0, 0, 0};
        queue.add(start);
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(temp[0] == n-1 && temp[1] == n-1) {
                dp[n-1][n-1] = Math.min(dp[n-1][n-1], temp[4] * 100 + temp[5] * 500);
                // System.out.println(dp[n-1][n-1]);
                
                // for(int i = 0; i < n; i++) {
                //     for(int j = 0; j < n; j++) {
                //         System.out.print(dp[i][j] + "      ");
                //     }System.out.println();
                // }System.out.println();
                
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int lx = temp[0] + dx[i];
                int ly = temp[1] + dy[i];
                
                if(lx >= 0 && lx < n && ly >= 0 && ly < n && board[lx][ly] == 0) {
                    int straight = temp[4];
                    int corner = temp[5];
                    
                    if(temp[2] == 0 && temp[3] == 0 || temp[2] == dx[i] && temp[3] == dy[i]) {
                        // 방향이 같음, 코너 생성 X
                        straight++;
                    }
                    else {
                        // 코너 생성 O
                        straight++;
                        corner++;
                    }
                    
                    int cost = straight * 100 + corner * 500;
                    
                    if(!visited[lx][ly][i]) {
                        queue.add(new int[] {lx, ly, dx[i], dy[i], straight, corner});
                        visited[lx][ly][i] = true;
                    }
                    else if(dp[lx][ly] >= cost) {
                        queue.add(new int[] {lx, ly, dx[i], dy[i], straight, corner});
                        visited[lx][ly][i] = true;
                        dp[lx][ly] = cost;
                    }
                    
                }
            }
        }
    }
}