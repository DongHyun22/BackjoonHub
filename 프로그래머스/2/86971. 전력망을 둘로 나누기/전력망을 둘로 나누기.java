import java.util.*;

class Solution {
    static int[][] map;
    static int n;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {
        map = new int[n][n];
        this.n = n;
        for(int i = 0; i < wires.length; i++) {
            map[wires[i][0] - 1][wires[i][1] - 1] = 1;
            map[wires[i][1] - 1][wires[i][0] - 1] = 1;
        }
        for(int i = 0; i < wires.length; i++) {
            map[wires[i][0] - 1][wires[i][1] - 1] = 0;
            map[wires[i][1] - 1][wires[i][0] - 1] = 0;
            int count = calc();
            if(answer > count)
                answer = count;
            map[wires[i][0] - 1][wires[i][1] - 1] = 1;
            map[wires[i][1] - 1][wires[i][0] - 1] = 1;
            
        }
        return answer;
    }
    public int calc() {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int a = 0;
        int b = 0;
        boolean check = false;
        for(int i = 0; i < n; i++) {
            if(visited[i] == true)
                continue;
            visited[i] = true;
            q.offer(i);
            while(!(q.isEmpty())) {
                int tmp = q.poll();
                for(int j = 0; j < n; j++) {
                    if(!visited[j] && map[tmp][j] == 1) {
                        visited[j] = true;
                        q.offer(j);
                        if(check) {
                            b++;
                            continue;
                        }
                        a++;
                        
                    }
                }
            }
            check = true;
        }
        return Math.abs(a - b);
    }
}