import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int pos;
    Node(int num, int pos) {
        this.num = num;
        this.pos = pos;
    }
    
    public int compareTo(Node o) {
        return o.num - num;
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        int cur = 0;
        int l = arr.length - k;
        
        
        for(int i = 0; i < l; i++) {
            char max = '0';
            for(int j = cur; j <= i + k; j++) {
                if(max < arr[j]) {
                    max = arr[j];
                    cur = j + 1; 
                    if(max == '9')
                        break;
                }
            }
            answer += max;
        }
        
        // while(cur < arr.length) {
        //     PriorityQueue<Node> pq = new PriorityQueue<>();
        //     for(int i = cur; i <= cur + k; i++) {
        //         pq.add(new Node(arr[i], i));
        //     }
        //     Node node = pq.poll();
        //     // cur ~ cur+k 중에서 가장 큰 수 답에 넣기
        //     answer += (char)node.num;
        //     // 답에 넣은 후 해당 위치 앞을 모두 삭제
        //     // 그 후 k - (삭제한 만큼의 수) <- 이 값이 0이면 모두 삭제한 것!
        //     k -= (node.pos - cur);
        //     if(k == 0) {
        //         // 남은 수 String에 넣고 탈출!
        //         for(int i = node.pos + 1; i < arr.length; i++) {
        //             answer += arr[i];
        //         }
        //         break;
        //     }
        //     // 현재 위치를 삭제한 위치 다음으로 설정
        //     cur = node.pos + 1;
        // }
        
        // 큐가 다 사라지면 종료
        return answer;
    }
}