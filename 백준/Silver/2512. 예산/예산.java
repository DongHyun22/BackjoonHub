import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left = 0;
        int right = arr[n-1];
        while(left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i = 0; i < n; i++) {
                if(arr[i] > mid) {
                    sum += mid;
                }
                else {
                    sum += arr[i];
                }
            }

            if(sum <= m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
