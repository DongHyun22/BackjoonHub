import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long[] arr, minTree;
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        minTree = new long[N * 4];

        Init(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            sb.append(MinFind(1, N, 1, a, b) + "\n");
        }

        System.out.println(sb.toString());
    }

    private static long MinFind(int start, int end, int node, long left, long right) {
        if (right < start || left > end) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(MinFind(start, mid, node * 2, left, right), MinFind(mid + 1, end, node * 2 + 1, left, right));

    }

    private static long Init(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(Init(start, mid, node * 2), Init(mid + 1, end, node * 2 + 1));

    }

}
