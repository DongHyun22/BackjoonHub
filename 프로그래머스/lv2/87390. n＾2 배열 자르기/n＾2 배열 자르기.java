import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)right - (int)left + 1;
        int[] answer = new int[length];
        int index = 0;
        for(long i = left; i < right + 1; i++){
            answer[index++] = Math.max((int)(i / n), (int)(i % n)) + 1;
        }
        return answer;
    }
}