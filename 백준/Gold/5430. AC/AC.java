import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int test = 0; test < n; test++) {
            String func = br.readLine();
            int l = Integer.parseInt(br.readLine());
            String temp = br.readLine();


            ArrayDeque<Integer> dq = new ArrayDeque<>();
            String number = "";
            if (!temp.equals("[]")) {
                for (char c : temp.toCharArray()) {
                    if (c == ',' || c == ']') {
                        dq.offer(Integer.parseInt(number));
                        number = "";
                    } else if (Character.isDigit(c)) {
                        number += c;
                    }
                }
            }


            solution(func, dq);
        }
        bw.flush();
        bw.close();
    }

    public static void solution(String func, ArrayDeque dq) throws IOException {
        boolean check = true;
        // true - 앞
        // false - 뒤

        for (char c : func.toCharArray()) {
            if (c == 'R') {
                check = !check;
            } else if (c == 'D') {
                if (dq.isEmpty()) {
                    bw.write("error" + "\n");
                    return;
                }
                if (check)
                    dq.pollFirst();
                else
                    dq.pollLast();
            }
        }
        if (dq.isEmpty()) {
            bw.write("[]" + "\n");
            return;
        }
        if (check) {
            bw.write("[");
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                bw.write(Integer.toString((Integer) dq.pollFirst()));
                if (i != size - 1)
                    bw.write(",");
            }
            bw.write("]" + "\n");
        } else {
            bw.write("[");
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                bw.write(Integer.toString((Integer) dq.pollLast()));
                if (i != size - 1)
                    bw.write(",");
            }
            bw.write("]" + "\n");
        }
    }
}