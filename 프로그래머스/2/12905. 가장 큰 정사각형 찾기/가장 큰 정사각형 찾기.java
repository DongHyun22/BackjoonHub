class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        if(n == 1 && m == 1) {
            return 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(board[i][j] != 0) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j])) + 1;
                }
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer*answer;
    }
}