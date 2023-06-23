import java.util.*;
import java.io.*;

public class Main {
    static int a, b, c;
    static boolean[][][] check;
    static Set<Integer> water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        check = new boolean[201][201][201];
        water = new TreeSet<>();

        dfs(0, 0, c);
        for(int num : water) {
            System.out.print(num + " ");
        }

    }
    public static void dfs(int na, int nb, int nc){
        if(check[na][nb][nc]) return;

        if(na == 0){
            water.add(nc);
        }
        check[na][nb][nc] = true;
        // c -> a
        if(nc >= a - na){
            dfs(a, nb, nc - (a - na));
        }
        else if(nc < a - na){
            dfs(na + nc, nb, 0);
        }
        // c -> b
        if(nc >= b - nb){
            dfs(na, b, nc - (b - nb));
        }
        else if(nc < b - nb){
            dfs(na, nb + nc, 0);
        }
        // b -> a
        if(nb >= a - na){
            dfs(a, nb - (a - na), nc);
        }
        else if(nb < a - na){
            dfs(na + nb, 0, nc);
        }
        // b -> c
        if(nb >= c - nc){
            dfs(na, nb - (c - nc), c);
        }
        else if(nb < c - nc){
            dfs(na, 0, nb + nc);
        }
        // a -> b
        if(na >= b - nb){
            dfs(na - (b - nb), b, nc);
        }
        else if(na < b - nb){
            dfs(0, na + nb, nc);
        }
        // a -> c
        if(na >= c - nc){
            dfs(na - (c - nc), nb, c);
        }
        else if(na < c - nc){
            dfs(0, nb, na + nc);
        }
    }
}