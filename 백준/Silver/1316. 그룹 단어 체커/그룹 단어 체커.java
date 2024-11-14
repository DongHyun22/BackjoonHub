import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            HashSet<Character> set = new HashSet<>();
            char pre = ' ';
            boolean flag = true;
            for(int j = 0; j < arr.length; j++) {
                char c = arr[j];
                if(set.contains(c) && pre != c) {
                    flag = false;
                    continue;
                }
                set.add(c);
                pre = c;
            }
            if(flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
