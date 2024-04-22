import java.util.*;

class Solution {
    static PriorityQueue<Integer> maxQ;
    static PriorityQueue<Integer> minQ;
    static int n;
    static String[] arr;
    static int pre;
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ = new PriorityQueue<>();
        arr = operations.clone();
        calc();
        if(n == 0) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else if(n == 1) {
            answer[0] = pre;
            answer[1] = pre;
        }
        else if(n == 2) {
            answer[0] = maxQ.poll();
            answer[1] = maxQ.poll();
        }
        else {
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        return answer;
    }
    
    public void calc() {
        for(int i = 0; i < arr.length; i++) {
            String s = arr[i].substring(0, 1);
            int temp = Integer.parseInt(arr[i].substring(2, arr[i].length()));
            if(s.equals("I"))
                addQ(temp);
            else
                pollQ(temp);
        }
     }
    
    public void addQ(int temp) {
        maxQ.add(temp);
        minQ.add(temp);
        pre = temp;
        n++;
    }
    
    public void pollQ(int temp) {
        if(n == 0) {
            return;
        }
        if(temp == 1)
            maxQ.poll();
        else
            minQ.poll();
        n--;
    }
}