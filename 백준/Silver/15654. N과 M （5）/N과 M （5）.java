import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        num = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        f(0);
    }
    public static void f(int count){
        if(count == m){
            for (int i = 0; i < m; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                num[count] = arr[i];
                f(count + 1);
                visited[i] = false;
            }
        }
    }
}