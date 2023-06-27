import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static double e, w, s, n;
    static boolean[][] visited;
    static double answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken())*0.01;
        w = Integer.parseInt(st.nextToken())*0.01;
        s = Integer.parseInt(st.nextToken())*0.01;
        n = Integer.parseInt(st.nextToken())*0.01;

        visited = new boolean[40][40];
        visited[20][20] = true;
        dfs(20, 20, 0, 1);
        String s = String.format("%.10f", answer);
        bw.write(s);
        bw.flush();
        bw.close();
    }
    public static void dfs(int x, int y, int move, double total){
        if(move == N){
            answer += total;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            double temp = total;
            if(i == 0){
                temp *= n;
            } else if(i == 1){
                temp *= e;
            } else if(i == 2){
                temp *= s;
            } else {
                temp *= w;
            }
            if(!visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, move+1, temp);
                visited[nx][ny] = false;
            }
        }
    }
}