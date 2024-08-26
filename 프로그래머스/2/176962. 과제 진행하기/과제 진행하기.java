import java.util.*;

class Node {
    String name;
    int start;
    int playtime;
    
    Node(String name, int start, int playtime) {
        this.name = name;
        this.start = start;
        this.playtime = playtime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (o1, o2) -> o1.start - o2.start
        );
        
        for(int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            
            String[] time = plans[i][1].split(":");
            int h = Integer.parseInt(time[0]);
            int m = Integer.parseInt(time[1]);
            int start = h * 60 + m;
            
            int playtime = Integer.parseInt(plans[i][2]);
            
            pq.add(new Node(name, start, playtime));
        }
        
        Stack<Node> stack = new Stack<>();
        int curTime = 0;
        
        while(!pq.isEmpty()) {
            Node curTask = pq.poll();
            
            curTime = curTask.start;
            if(!pq.isEmpty()) {
                Node nextTask = pq.peek();
                if(curTime + curTask.playtime < nextTask.start) {
                    curTime += curTask.playtime;
                    answerList.add(curTask.name);
                    while(!stack.isEmpty()) {
                        Node stopTask = stack.pop();
                        if(curTime + stopTask.playtime <= nextTask.start) {
                            curTime += stopTask.playtime;
                            answerList.add(stopTask.name);
                            continue;
                        }
                        else {
                            stopTask.playtime -= nextTask.start - curTime;
                            stack.push(stopTask);
                            break;
                        }
                    }
                }
                else if(curTime + curTask.playtime == nextTask.start) {
                    answerList.add(curTask.name);
                }
                else {
                    curTask.playtime -= nextTask.start - curTime;
                    stack.push(curTask);
                }
            }
            else {
                curTime += curTask.playtime;
                answerList.add(curTask.name);
                while(!stack.isEmpty()) {
                    Node stopTask = stack.pop();
                    curTime += stopTask.playtime;
                    answerList.add(stopTask.name);
                }
            }
            
            
        }
        // 현재 과제 저장 poll
        // 1. 다음 과제 있을 때 실행
        //    다음 과제 저장 peek
        //   a. 현재 시간 + 현재 과제 playtime < 다음 과제 시작 시간
        //     끝내기
        //     i. 멈춘 과제가 있으면 과제 실행
        //       1. 현재 시간 + 멈춘 과제 playtime <= 다음 과제 시작 시간
        //         a. 끝내기
        //       2. 현재 시간 + 멈춘 과제 playtime > 다음 과제 시작 시간
        //         b. 멈춘 과제에 넣기
        //   b. 현재 시간 + 현재 과제 playtime == 다음 과제 시작 시간
        //     i. 끝내기
        //   c. 현재 시간 + 현재 과제 playtime > 다음 과제 시작 시간
        //     i. 멈춘 과제에 넣기
        // 2. 다음 과제가 없으면 실행
        //   a. 멈춘 과제도 없으면 종료
        //   b. 멈춘 과제가 있으면
        //     i. 다음 과제 끝내기
        //     ii. 멈춘 과제 순서대로 끝내기
        
        answer = answerList.toArray(new String[answerList.size()]);
        
        return answer;
    }
}