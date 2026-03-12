import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = Integer.MAX_VALUE;

        // 1. 왼쪽 블루 일 때
        int count = 0;

        // 1-1 블루 옮길 때
        boolean flag = true;
        if(s.charAt(0) == 'B')
            flag = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'B' && flag) {
                count++;
            }
            else if(c == 'R') {
                flag = true;
            }
        }
        answer = Math.min(answer, count);
        // 1-2 레드 옮길 때
        if(s.charAt(n-1) == 'R')
            flag = false;
        count = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'R' && flag) {
                count++;
            }
            else if(c == 'B') {
                flag = true;
            }
        }
        answer = Math.min(answer, count);

        // 2. 왼쪽 레드 일 때

        // 2-1 블루 옮길 때
        if(s.charAt(n-1) == 'B')
            flag = false;
        count = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'B' && flag) {
                count++;
            }
            else if(c == 'R') {
                flag = true;
            }
        }
        answer = Math.min(answer, count);

        // 2-2 레드 옮길 때
        if(s.charAt(0) == 'R')
            flag = false;
        count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'R' && flag) {
                count++;
            }
            else if(c == 'B') {
                flag = true;
            }
        }
        answer = Math.min(answer, count);

        System.out.println(answer);
    }
}
