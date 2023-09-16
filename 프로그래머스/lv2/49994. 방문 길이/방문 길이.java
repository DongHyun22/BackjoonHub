class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int x = 5;
        int y = 5;
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int dx = x;
            int dy = y;
            if(c == 'U') {
                dy += 1;
            }
            else if(c == 'D') {
                dy -= 1;
            }
            else if(c == 'R') {
                dx += 1;
            }
            else {
                dx -= 1;
            }
            if(dx >= 0 && dx <= 10 && dy >= 0 && dy <= 10) {
                if(!visited[x][y][dx][dy] || !visited[dx][dy][x][y]) {
                    answer++;
                    visited[x][y][dx][dy] = true;
                    visited[dx][dy][x][y] = true;
                }
                x = dx;
                y = dy;
            }
        }
        return answer;
    }
}