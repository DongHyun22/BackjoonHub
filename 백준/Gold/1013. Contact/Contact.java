import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        String regex = "(100+1+|01)+";

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.matches(regex)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}