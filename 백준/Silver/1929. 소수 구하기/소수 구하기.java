import java.util.*;
import java.io.*;

public class Main {
    static boolean[] primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        primes = new boolean[m+1];

        isPrime(m);

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (primes[i]) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    static void isPrime(int n){
        primes = new boolean[n+1]; // N번째의 수 까지 받기위해 N+1까지 동적할당

        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(primes[i]){
                for(int j = i*i; j<= n; j += i){
                    primes[j] = false;
                }
            }
        }
    }

}
