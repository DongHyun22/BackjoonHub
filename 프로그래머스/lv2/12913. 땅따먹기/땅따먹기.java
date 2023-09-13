class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < 4; j++){
                int a = dp[i][(j+1)%4] + land[i+1][j];
                int b = dp[i][(j+2)%4] + land[i+1][j];
                int c = dp[i][(j+3)%4] + land[i+1][j];
                dp[i+1][j] = Math.max(a, Math.max(b, c));
            }
        }
        for(int i = 0 ; i < 4; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        
        return answer;
    }
}