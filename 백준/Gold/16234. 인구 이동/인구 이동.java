import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. n, l, r 입력받기
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] region = new int[n][n];
        // 2. 일수 변수 생성
        int day = 0;

        // 3. 땅 인구 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int a = 0; a < n; a++) {
//            for (int b = 0; b < n; b++) {
//                System.out.print(region[a][b]);
//            }
//            System.out.println();
//        }

        // 1. bfs를 통해 연합을 이중배열에 체크한다 ( 체크와 동시에 이동 여부 체크 )
        // 2. bfs 종료 후 체크한 연합을 계산하여 값 수정
        // 3. 이중for문이 종료 후 인구이동이 이루어졌으면 일수+1 후 재 반복 or 종료

        while (true) {
            boolean[][] visited = new boolean[n][n];
            boolean check = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j])
                        continue;

                    list = new ArrayList<>();
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    list.add(new int[] {i, j});
                    int sum = region[i][j];

                    while (!queue.isEmpty()) {
                        int[] loc = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = loc[0] + dx[k];
                            int y = loc[1] + dy[k];
                            if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                                int value = Math.abs(region[loc[0]][loc[1]] - region[x][y]);
                                if (value >= l && value <= r) {
                                    queue.add(new int[]{x, y});
                                    visited[x][y] = true;
                                    check = true;
                                    list.add(new int[] {x, y});
                                    sum += region[x][y];
                                }
                            }
                        }
                    }


                    int moveValue = sum / list.size();
                    for(int[] loc : list) {
                        region[loc[0]][loc[1]] = moveValue;
                    }

                }
            }

            if (check) {
                day++;
            } else {
                break;
            }
        }

        bw.write(String.valueOf(day));
        bw.flush();
    }
}
