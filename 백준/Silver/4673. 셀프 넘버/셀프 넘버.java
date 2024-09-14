import java.io.*;

public class Main {
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        arr = new boolean[100000];
        for(int i = 9999; i >= 1; i--) {
            arr[calc(i)] = true;
        }
        for(int i = 1; i < 10000; i++) {
            if(!arr[i])
                System.out.println(i);
        }
    }
    static public int calc(int n) {
        int result = n;
        while(n != 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
