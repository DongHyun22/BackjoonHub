import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 0; j < 20; j++) {
                int l = Integer.parseInt(st.nextToken());
                // 키
                int size = list.size();
                boolean flag = false;
                for(int k = 0; k < size; k++) {
                    if(list.get(k) > l) {
                        list.add(k, l);
                        answer += size - k;
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    list.add(l);
                }
            }
            System.out.println(m + " " + answer);
        }
    }
}
