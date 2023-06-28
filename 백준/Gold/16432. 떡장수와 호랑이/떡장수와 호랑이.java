import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<Integer>[] rice;
    static int[] answer;
    static boolean[][] visited;
    static boolean check;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        rice = new ArrayList[n];
        answer = new int[n];
        visited = new boolean[n][10];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rice[i] = new ArrayList<>();
            int l = Integer.parseInt(st.nextToken());
            for (int j = 0; j < l; j++) {
                rice[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        dfs(0, -1);
        if(!check)
            bw.write("-1");
        bw.flush();
        bw.close();
    }
    static void dfs(int day, int pre) throws IOException {
        if(day == n){
            for (int i = 0; i < answer.length; i++) {
                bw.write(answer[i] + "\n");
            }
            check = true;
            return;
        }
        for (int j = 1; j < 10; j++) {
            if(j != pre && !visited[day][j] && rice[day].contains(j)){
                visited[day][j] = true;
                answer[day] = j;
                dfs(day + 1, j);
                if(check)
                    return;
            }
        }
    }
}