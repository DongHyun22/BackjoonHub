import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];
        for(int i = 0; i < n; i++) {
            temp1[i] = binaryChange(arr1[i], n);
            temp2[i] = binaryChange(arr2[i], n);
        }
        for(int i = 0; i < n; i++) {
            String temp = new String();
            for(int j = 0; j < n; j++) {
                if(temp1[i].charAt(j) == '1' || temp2[i].charAt(j) == '1') {
                    temp += "#";
                }
                else {
                    temp += " ";
                }
            }
            answer[i] = temp;
        }
        return answer;
        
    }
    
    public String binaryChange(int num, int n) {
        String s = Integer.toBinaryString(num);
        while(s.length() < n) {
            s = "0" + s;
        }
        return s;
    }
}