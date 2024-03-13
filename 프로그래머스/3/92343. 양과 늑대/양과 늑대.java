class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        dfs(info, edges, 1, 0);

        return answer;
    }
    public void dfs(int[] info, int[][] edges, int sheeps, int wolfs) {
        if(sheeps > wolfs) {
            if(sheeps > answer)
                answer = sheeps;
        }
        else
            return;
        
        for(int[] arr : edges) {
            if(visited[arr[0]] && !visited[arr[1]]) {
                visited[arr[1]] = true;
                if(info[arr[1]] == 0) {
                    dfs(info, edges, sheeps+1, wolfs);
                }
                else {
                    dfs(info, edges, sheeps, wolfs+1);
                }
                visited[arr[1]] = false;
            }
        }
            
        
    }
}
