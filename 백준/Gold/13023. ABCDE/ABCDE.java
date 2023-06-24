import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int answer;
    static ArrayList<Integer>[] member;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        member = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            member[i] = new ArrayList<>(n);
        }
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            member[x].add(y);
            member[y].add(x);
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if(answer == 1){
                break;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();

    }
    public static void dfs(int num, int depth){
//        System.out.println(num + " " + depth);
        if(depth == 5 || answer == 1){
            answer = 1;
            return;
        }
        for (int i : member[num]) {
            if(num != i && !visited[i]){
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
                if(answer == 1){
                    return;
                }
            }
        }
    }
}