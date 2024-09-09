import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int k = 0; k < t; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n-1];
            long answer = 0;
            boolean flag = false;
            ArrayList<Integer> list = new ArrayList<>();


            for(int i = n-2; i >= 0; i--) {
                int num = arr[i];

                if(!flag) {
                    if(max < num) {
                        max = num;
                    }
                    else if(max > num){
                        list.add(num);
                        flag = !flag;
                    }
                    continue;
                }

                if(max < num) {
                    // list에있는 값으로 수익률 계산하여 더하기
                    for(int temp: list) {
                        answer += max - temp;
                    }
                    // list 초기화
                    list = new ArrayList<>();
                    // max 초기화
                    max = num;
                }
                else if(max > num){
                    list.add(num);
                }
            }
            for(int temp: list) {
                answer += max - temp;
            }

            System.out.println(answer);
        }

    }
}
