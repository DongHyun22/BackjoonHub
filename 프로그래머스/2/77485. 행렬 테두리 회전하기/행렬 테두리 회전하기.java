import java.util.*;

class Solution {
    static int w;
    static int h;
    static int[][] map;
    static int[] answer;
    static int l;
    public int[] solution(int rows, int columns, int[][] queries) {
        l = queries.length;
        answer = new int[l];
        w = rows;
        h = columns;
        map = new int[w][h];
        int num = 1;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                map[i][j] = num++;
            }
        }
        
        for(int i = 0; i < l; i++) {
            answer[i] = calc(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
        }
        
        // 회전하며 가장 큰 작은 수
        
        
        return answer;
    }
    
    public int calc(int x1, int y1, int x2, int y2) {
        
        int temp = map[x1][y1];
        int min = temp;
        
        for(int i = x1; i < x2; i++) {
            map[i][y1] = map[i+1][y1];
            min = Math.min(min, map[i+1][y1]);
        }

        for(int i = y1; i < y2; i++) {
            map[x2][i] = map[x2][i+1];
            min = Math.min(min, map[x2][i+1]);
        }
        
        
        for(int i = x2; i > x1; i--) {
            map[i][y2] = map[i-1][y2];
            min = Math.min(min, map[i-1][y2]);
        }

        for(int i = y2; i > y1; i--) {
            map[x1][i] = map[x1][i-1];
            min = Math.min(min, map[x1][i-1]);
        }
        map[x1][y1 + 1] = temp;
        
        
        return min;
    }
}