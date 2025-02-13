import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if(i < 100) {
                answer++;
            }
            else if(calc(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean calc(int num) {
        boolean result = true;
        String s = String.valueOf(num);
        int p = (s.charAt(0) - '0') - (s.charAt(1) - '0');
        for(int i = 1; i < s.length(); i++) {
            if(p != (s.charAt(i-1) - s.charAt(i))) {
                result = false;
                break;
            }
        }

        return result;
    }
}
