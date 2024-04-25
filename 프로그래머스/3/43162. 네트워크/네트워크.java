class Solution {
    static boolean[] visited;
    static int n;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(visited[i])
                continue;
            answer++;
            dfs(i, computers);
        }
        return answer;
    }
    
    public void dfs(int cur, int[][] computers) {
        visited[cur] = true;
        for(int i = 0; i < n; i++) {
            if(visited[i])
                continue;
            if(computers[cur][i] == 1)
                dfs(i, computers);
        }
    }
}