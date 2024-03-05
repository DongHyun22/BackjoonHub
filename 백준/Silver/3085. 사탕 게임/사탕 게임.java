import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 보드 채우기
        int n = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(board[i]);
//        }

        int max = 1;
        // 2. 사탕의 색이 다른 인접한 두 칸을 교환 - 방문했거나 색이 같으면 패스
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < 4; k++) {
                    int lx = i + dx[k];
                    int ly = j + dy[k];
                    // 각 케이스별 최대 개수 구하기 - 최대값 max 설정
                    if(lx >= 0 && ly >= 0 && lx < n && ly < n && visited[lx][ly] == false && board[i][j] != board[lx][ly]) {
                        char temp = board[i][j];
                        board[i][j] = board[lx][ly];
                        board[lx][ly] = temp;


                        for (int l = 0; l < n; l++) {
                            char pre = board[l][0];
                            int now = 1;
                            for (int m = 1; m < n; m++) {
                                if(pre == board[l][m]) {
                                    now++;
                                    if(m == n-1 && max < now) {
                                        max = now;
                                    }
                                }
                                else {
                                    if(max < now) {
                                        max = now;
                                    }
                                    pre = board[l][m];
                                    now = 1;
                                }
                            }
                        }

                        for (int l = 0; l < n; l++) {
                            char pre = board[0][l];
                            int now = 1;
                            for (int m = 1; m < n; m++) {
                                if(pre == board[m][l]) {
                                    now++;
                                    if(m == n-1 && max < now) {
                                        max = now;
                                    }
                                }
                                else {
                                    if(max < now) {
                                        max = now;
                                    }
                                    pre = board[m][l];
                                    now = 1;
                                }
                            }
                        }

                        temp = board[i][j];
                        board[i][j] = board[lx][ly];
                        board[lx][ly] = temp;

                    }

                }
                visited[i][j] = true;
            }
        }
        System.out.println(max);

    }
}
