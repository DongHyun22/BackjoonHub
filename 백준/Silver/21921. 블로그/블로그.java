import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        int sum_max = sum;
        int count = 1;
        for(int i = 0; i < n-m; i++) {
            sum -= arr[i];
            sum += arr[i+m];
            if(sum > sum_max) {
                sum_max = sum;
                count = 1;
            }
            else if(sum == sum_max) {
                count++;
            }
        }

        System.out.println(sum_max);
        System.out.println(count);

    }
}
