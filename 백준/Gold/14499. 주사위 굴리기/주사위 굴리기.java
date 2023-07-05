import java.util.*;
import java.io.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[] command;
    static int[][] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        char[] s;
        for (int i = 0; i < n; i++) {
            s = br.readLine().replace(" ", "").toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = s[j] - '0';
            }
        }
        s = br.readLine().replace(" ", "").toCharArray();
        command = new int[k];
        for (int i = 0; i < k; i++) {
            command[i] = s[i] - '0';
        }
        dice = new int[4][3];
        solution();
    }

    public static void solution() {
        for (int i = 0; i < k; i++) {
            int dir = command[i];
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            moveDice(dir);
            System.out.println(dice[1][1]);
            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[3][1];
            } else {
                dice[3][1] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
        }
    }

    public static void moveDice(int dir) {
        int temp;
        switch (dir) {
            case 1: // 주사위 동쪽
                temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                return;
            case 2:
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                return;
            case 3:
                temp = dice[0][1];
                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }
                dice[3][1] = temp;
                return;
            case 4:
                temp = dice[3][1];
                for (int i = 2; i >= 0; i--) {
                    dice[i + 1][1] = dice[i][1];
                }
                dice[0][1] = temp;

        }
    }
}