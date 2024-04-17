import java.util.*;

class Solution {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        
        int[][] answer = new int[list.size()][2];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public void hanoi(int n, int start, int mid, int end) {
        if(n == 1) {
            list.add(new int[]{start, end});
            return;
        }
        
        hanoi(n-1, start, end, mid);
        
        // 하나 옮기기
        list.add(new int[]{start, end});
        
        hanoi(n-1, mid, start, end);
    }
}