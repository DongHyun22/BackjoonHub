import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int answer;
    static Set<Integer> eq_number;
    static Set<Integer> temp_number;
    static Set<Integer> number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[2][n + 1];
        visited = new boolean[n + 1];
        eq_number = new TreeSet<>();
        temp_number = new TreeSet<>();
        number = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            if (i == arr[1][i]) {
                eq_number.add(i);
                visited[i] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp_number.add(i);
                dfs(i, arr[1][i], 1);
                visited[i] = false;
                temp_number.clear();
            }
        }
        number.addAll(eq_number);
        bw.write(number.size() + "\n");
        for (int i : number) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int origin, int i, int depth) {
        if (origin == i) {
                number.addAll(temp_number);
                return;
        }
        if (!visited[i]) {
            visited[i] = true;
            temp_number.add(i);
            dfs(origin, arr[1][i], depth + 1);
            visited[i] = false;
        }

    }
}