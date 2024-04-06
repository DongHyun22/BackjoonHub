import java.util.*;

class Solution {
    static boolean[] isPrime;
    static boolean[] visited;
    static boolean[] selected;
    static int answer;
    static char[] arr;
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        String s = sb.reverse().toString();
        
        int n = Integer.parseInt(s);
        findPrime(n);
        
        // 순열을 통해 경우의 수를 구한 후 소수 판단
        for(int i = 1; i <= arr.length; i++) {
            selected = new boolean[arr.length];
            perm(0, i, new int[i]);
        }
        return answer;
        
    }
    
    public void perm(int cur, int max, int[] array) {
        if(cur == max) {
            String s = "";
            for(int i = 0; i < array.length; i++) {
                s += array[i];
            }
            int tmp = Integer.parseInt(s);
            if(!visited[tmp] && isPrime[tmp]) {
                answer++;
                visited[tmp] = true;
            }
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(selected[i])
                continue;
            selected[i] = true;
            int tmp = arr[i] - '0';
            array[cur] = tmp;
            perm(cur + 1, max, array);
            selected[i] = false;
        }
    }
    
    // 소수 판별 함수 ( 에라토스테네스의 체)
    // 최댓값을 넣어 실행
    public void findPrime(int n) {
        isPrime = new boolean[9999999];
        visited = new boolean[9999999];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i*i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return;
    }
}