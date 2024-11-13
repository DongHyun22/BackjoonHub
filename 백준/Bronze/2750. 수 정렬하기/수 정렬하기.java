import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
