import java.util.*;
import java.io.*;

class Pair{
    int index;
    int value;
    int jump;

    public Pair(int index, int value, int jump) {
        this.index = index;
        this.value = value;
        this.jump = jump;
    }
}
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static int start;
    static int end;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair (start, arr[start], 1));
        visited[start] = true;
        out:while(!q.isEmpty()){
            Pair now = q.poll();
            int index = now.index;
            int value = now.value;
            int jump = now.jump;
            for(int i = 1;;i++){
                int temp = value * i;
                if(index - temp <= 0 && index + temp >= 10000)
                    break;
                if(index - temp > 0 && !visited[index - temp]){
                    if(index - temp == end){
                        answer = jump;
                        break out;
                    }
                    q.offer(new Pair(index - temp, arr[index - temp], jump+1));
                    visited[index - temp] = true;
                }
                if(index + temp < n + 1 &&
                        !visited[index + temp]){
                    if(index + temp == end){
                        answer = jump;
                        break out;
                    }
                    q.offer(new Pair(index + temp, arr[index + temp], jump+1));
                    visited[index + temp] = true;
                }
            }
        }
        System.out.println(answer);
    }
}