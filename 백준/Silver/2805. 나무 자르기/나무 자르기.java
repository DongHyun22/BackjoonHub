import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr[n-1];
        int mid = 0;
        while(left < right) {
            mid = (left + right) / 2;

            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] - mid > 0) {
                    sum += arr[i] - mid;
                }
            }
            if(sum >= m) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        answer = left - 1;
        System.out.println(answer);
    }
}
