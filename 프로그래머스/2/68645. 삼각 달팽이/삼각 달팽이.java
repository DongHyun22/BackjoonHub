import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] map = new int[1001][1001];
        int num = 1;
        int count = n;
        int x = 0;
        int y = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = count; j > 0; j--) {
                if(i % 3 == 1) {
                    map[x++][y] = num++;
                    if(j == 1) {
                        x--;
                        y++;
                    }
                }
                else if(i % 3 == 2) {
                    map[x][y++] = num++;
                    if(j == 1) {
                        y--;
                        x--;
                        y--;
                    }
                }
                else {
                    map[x--][y--] = num++;
                    if(j == 1) {
                        x++;
                        y++;
                        x++;
                    }
                }
            }
            count--;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != 0) {
                    list.add(map[i][j]);
                }
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}