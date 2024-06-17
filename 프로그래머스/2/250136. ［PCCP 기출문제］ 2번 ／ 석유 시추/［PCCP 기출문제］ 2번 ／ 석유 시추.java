import java.util.*;

class Solution {
    static int answer = 0;
    static int n;
    static int m;
    static int count = 1;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[][] matrix;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        matrix = new int[n][m];
        bfs(land);
        
        for(int i = 0; i < m; i++) {
            int sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(matrix[j][i] != 0 && !set.contains(matrix[j][i])) {
                    set.add(matrix[j][i]);
                    sum += map.get(matrix[j][i]);
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public void bfs(int[][] land) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    int sum = 0;
                    queue.add(new int[]{i, j});
                    matrix[i][j] = count;
                    visited[i][j] = true;
                    sum++;
                    while(!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        for(int d = 0; d < 4; d++) {
                            int lx = arr[0] + dx[d];
                            int ly = arr[1] + dy[d];
                            if(lx >= 0 && lx < n && ly >= 0 && ly < m && land[lx][ly] == 1 && !visited[lx][ly]) {
                                queue.add(new int[]{lx, ly});
                                matrix[lx][ly] = count;
                                visited[lx][ly] = true;
                                sum++;
                            }
                        }
                    }
                    map.put(count, sum);
                    count++;
                }
            }
        }
    }
}