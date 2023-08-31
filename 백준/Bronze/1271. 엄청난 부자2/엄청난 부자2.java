import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Main{

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
         
        BigInteger n = new BigInteger(strArr[0]);
        BigInteger m = new BigInteger(strArr[1]);
        System.out.print(n.divide(m) + "\n" + n.remainder(m));
     }
}