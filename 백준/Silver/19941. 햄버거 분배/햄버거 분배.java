import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'H') {
                continue;
            }
            boolean flag = false;
            for (int j = k; j > 0; j--) {
                if (i - j >= 0 && i - j < n && arr[i - j] == 'H' && visited[i - j] == false) {
                    count++;
                    visited[i - j] = true;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int j = 1; j <= k; j++) {
                    if (i + j >= 0 && i + j < n && arr[i + j] == 'H' && visited[i + j] == false) {
                        count++;
                        visited[i + j] = true;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
