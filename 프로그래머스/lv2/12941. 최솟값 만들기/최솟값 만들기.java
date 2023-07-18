import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] temp = new Integer[B.length];
        for(int i = 0; i < B.length; i++){
            temp[i] = B[i];
        }
        Arrays.sort(temp, Collections.reverseOrder());
        for(int i = 0; i < A.length; i++){
            answer += A[i] * temp[i];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}