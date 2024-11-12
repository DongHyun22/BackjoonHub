import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;

        if(a == b && b == c) {
            answer = three(a);
        }
        else if(a == b) {
            answer = two(a);
        }
        else if(b == c) {
            answer = two(b);
        }
        else if(c == a) {
            answer = two(c);
        }
        else {
            answer = one(Math.max(a, Math.max(b, c)));
        }

        System.out.println(answer);
    }

    public static int three(int num) {
        return 10000 + num * 1000;
    }
    public static int two(int num) {
        return 1000 + num * 100;
    }
    public static int one(int num) {
        return num * 100;
    }
}
