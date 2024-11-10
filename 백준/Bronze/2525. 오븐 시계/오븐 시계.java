import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = Integer.parseInt(br.readLine());

        sum %= 24*60;
        h += sum / 60;
        m += sum % 60;

        if(m >= 60) {
            h += 1;
            m %= 60;
        }
        if(h >= 24) {
            h %= 24;
        }

        System.out.println(h + " " + m);
    }
}
