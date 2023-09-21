import java.util.*;

class Solution {
    static char[][] game;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        game = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                game[i][j] = board[i].charAt(j);
            }
        }
        while(true) {
            boolean[][] delete = new boolean[m][n];
            boolean flag = true;
            // 지울 블록 체크
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n - 1; j++) {
                    char c = game[i][j];
                    if(c == 'X') continue;
                    if(check(c, game[i+1][j], game[i][j+1], game[i+1][j+1])) {
                        delete[i][j] = true;
                        delete[i+1][j] = true;
                        delete[i][j+1] = true;
                        delete[i+1][j+1] = true;
                        flag = false;
                    }
                }
            }
            // for(int i = 0; i < m; i++) {
            //     for(int j = 0; j < n; j++) {
            //         System.out.print(game[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            if(flag) break;
            // 삭제
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(delete[i][j]) {
                        game[i][j] = 'X';
                        answer++;
                    }
                }
            }
            // 내리기
            ArrayDeque<Character> q = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                for(int j = m-1; j >= 0; j--) {
                    if(game[j][i] != 'X') {
                        q.offer(game[j][i]);
                        game[j][i] = 'X';
                    }
                }
                int index = m-1;
                while(!q.isEmpty()) {
                    game[index--][i] = q.poll();
                }
            }
        }
        return answer;
    }
    public boolean check(char c, char ta, char tb, char tc) {
        if(c == ta && c == tb && c == tc) {
            return true;
        }
        return false;
    }
}