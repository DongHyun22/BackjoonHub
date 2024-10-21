import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] myArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            myArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[m];

        Arrays.sort(myArr);

        for(int i = 0; i < m; i++) {
            int num = arr[i];
            int left = 0;
            int right = n;
            boolean flag = false;
            while(left < right) {
                int mid = (left + right) / 2;

                if(myArr[mid] < num) {
                    left = mid + 1;
                }
                else if (myArr[mid] > num) {
                    right = mid;
                }
                else {
                    flag = !flag;
                    break;
                }
            }
            if(flag) answer[i] = 1;
            else answer[i] = 0;
        }

        for (int num: answer) {
            System.out.print(num + " ");
        }

    }
}
