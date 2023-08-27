class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            boolean[] visited = new boolean[8];
            if(dungeons[i][0] <= k){
                visited[i] = true;
                bf(k - dungeons[i][1], dungeons, visited, 1);
                visited[i] = false;
            }
            
        }
        return answer;
    }
    public void bf(int k, int[][] dungeons, boolean[] visited, int count){
        boolean flag = true;
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k){
                flag = false;
                visited[i] = true;
                bf(k - dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
        if(flag) {
            answer = Math.max(answer, count);
        }
    }
}