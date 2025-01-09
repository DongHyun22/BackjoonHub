import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int k = 0; k < n; k++) {
        st = new StringTokenizer(br.readLine());
        pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            sb.append(pq.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
