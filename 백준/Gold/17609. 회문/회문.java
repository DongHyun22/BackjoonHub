import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[] c;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            c = br.readLine().toCharArray();
            int front = 0;
            int back = c.length - 1;

            int a = check(front, back, 0);
            answer[i] = a;
        }


        for (int i : answer) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int check(int front, int back, int a) {
        while (front < back) {
            if (c[front] == c[back]) {
                front++;
                back--;
                continue;
            }
            if (a != 0) {
                return 2;
            }
            a = 1;
            int temp = check(front, back - 1, a);
            if (temp == 1) {
                back--;
                continue;
            }
            temp = check(front + 1, back, a);
            if (temp == 1) {
                front++;
                continue;
            }
        }
        return a;
    }
}
