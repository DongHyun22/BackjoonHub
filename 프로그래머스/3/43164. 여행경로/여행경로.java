import java.util.*;

class Solution {
    static String s;
    static int n;
    static ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        n = tickets.length;
        boolean[] visited = new boolean[n];
        dfs(0, "ICN", "ICN", visited, tickets);
        
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        
        return answer;
    }
    public void dfs(int num, String name, String temp, boolean[] visited, String[][] tickets) {
        if(num == n) {
            list.add(temp);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(tickets[i][0].equals(name) && !visited[i]) {
                visited[i] = true;
                dfs(num + 1, tickets[i][1], temp + " " + tickets[i][1], visited, tickets);
                visited[i] = false;
            }
        }
    }
}