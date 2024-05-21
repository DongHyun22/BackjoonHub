import java.util.*;

class Solution {
    static boolean[][] map;
    static int answer;
    static int max;
    public int solution(int n, int[][] edge) {
        map = new boolean[n][n];
        for(int i = 0; i < edge.length; i++) {
            map[edge[i][0] - 1][edge[i][1] - 1] = true;
            map[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        
        bfs(n);
        
        return answer;
    }
    
    public void bfs(int n) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        queue.add(new int[] {0, 0});
        visited[0] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.pop();
            if(temp[1] > max) {
                max = temp[1];
                answer = 1;
            }
            else if(temp[1] == max) {
                answer++;
            }
            
            for(int i = 1; i < n; i++) {
                if(map[temp[0]][i] && !visited[i]) {
                    queue.add(new int[] {i, temp[1] + 1});
                    visited[i] = true;
                }
            }
        }
    }
}