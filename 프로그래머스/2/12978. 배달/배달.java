import java.util.*;

class Solution {
    static int n;
    static int k;
    static int[][] min;
    
    static int answer;
    public int solution(int N, int[][] road, int K) {
        n = N;
        k = K;
        min = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(min[i], 10000*2000*50);
        }
        
        for(int i = 0; i < road.length; i++) {
            int x = road[i][0];
            int y = road[i][1];
            int t = road[i][2];
            min[x][y] = Math.min(min[x][y], t);
            min[y][x] = Math.min(min[y][x], t);
        }
        
        min[1][1] = 0;
        calc();

        for(int i = 1; i <= n; i++) {
            if(min[1][i] <= k)
                answer++;
        }
        return answer;
    }
    // 탐색 위치
    public void calc() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <=n; k++) {
                    min[j][k] = Math.min(min[j][i] + min[i][k], min[j][k]);
                }
                
            }
        }
    }
}

//         for(int i = 1; i <= n; i++) {
//             for(int j = 1; j <= n; j++) {
//                 if(map[i][j].isEmpty())
//                     continue;
//                 System.out.print(i + "에서 " + j + "의 도로는 ");
//                 for(int time : map[i][j]) {
//                     System.out.print(time + ", ");
//                 }
//                 System.out.println("이 있습니다.");
//             }
//         }