import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> list = new ArrayList<>();
        while(true) {
            String s = br.readLine();
            if(s.equals("end"))
                break;
            list.add(s);
        }

        ArrayList<Character> gather = new ArrayList<>();
        gather.add('a');
        gather.add('e');
        gather.add('i');
        gather.add('o');
        gather.add('u');

        for(int testcase = 0; testcase < list.size(); testcase++) {
            String password = list.get(testcase);
            char[] arr = password.toCharArray();
            boolean check = true;

            boolean gc = false;

            int cons_count = 0;
            int gather_count = 0;

            char pre = ' ';

            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (gather.contains(c)) {
                    // 1 조건
                    gc = true;

                    // 2 조건
                    if(cons_count > 0) {
                        cons_count = 0;
                        gather_count = 1;
                    }
                    else if(gather_count == 2){
                        check = false;
                        break;
                    }
                    else {
                        gather_count++;
                    }

                    // 3 조건
                    if(pre == c) {
                        if(c != 'e' && c != 'o') {
                            check = false;
                            break;
                        }
                    }
                    pre = c;
                }
                else {
                    if(gather_count > 0) {
                        cons_count = 1;
                        gather_count = 0;
                    }
                    else if(cons_count == 2){
                        check = false;
                        break;
                    }
                    else {
                        cons_count++;
                    }

                    // 3 조건
                    if(pre == c) {
                        check = false;
                        break;
                    }
                    pre = c;
                }
            }

            if (check && gc)
                System.out.println("<" + password + "> is acceptable.");
            else
                System.out.println("<" + password + "> is not acceptable.");

            // 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
            // 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            // 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.

        }
    }
}
