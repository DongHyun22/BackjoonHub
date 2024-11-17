import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<int[]> list = new ArrayList<>();
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (o1, o2) -> o1[2] - o2[2]);

        int answer = 0;

        for(int i = 0; i < m; i++) {

            int[] temp = list.get(i);

            if(find(temp[0]) != find(temp[1])) {
                answer += temp[2];
                union(temp[0], temp[1]);
            }
        }


        System.out.println(answer);

    }
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }
}
