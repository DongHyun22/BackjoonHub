import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long left = 0;
        long right = arr[k-1] + 1;
        while(left < right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < k; i++) {
                sum += arr[i] / mid;
            }

            if(sum < n) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }
}
