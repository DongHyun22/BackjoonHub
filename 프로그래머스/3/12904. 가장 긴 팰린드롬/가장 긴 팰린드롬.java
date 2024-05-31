class Solution {
    static boolean[][] dp;
    static int n;
    public int solution(String s) {
        int answer = 1;
        n = s.length();
        char[] arr = s.toCharArray();
        dp = new boolean[n][n];
        // 길이가 1인건 모두 팰린드롬
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // 길이가 2인건 두 글자가 같으면 팰린드롬
        for(int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
                answer = 2;
            }
        }
        
        // 길이가 3이상일 때 i~j의 문자열은 i+1 ~ j-1의 dp가 true이고 i값과 j값이 같으면 팰린드롬이다.
        // 이때의 길이의 최댓값 구하기
        for(int l = 3; l <= n; l++) {
            for(int i = 0; i < n-l+1; i++) {
                int j = i + l - 1;
                if(arr[i] == arr[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    answer = Math.max(answer, l);
                }
            }
        }
        
        return answer;
    }
}