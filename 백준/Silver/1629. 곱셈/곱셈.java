import java.util.*;
import java.io.*;

public class Main {
    static long a;
    static long b;
    static int c;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = solution(a, b);
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static long solution(long a, long b) {
        if(b == 1) {
            return a % c;
        }

        long tmp = solution(a, b / 2);

        if(b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }

        return tmp * tmp % c;
    }
}
