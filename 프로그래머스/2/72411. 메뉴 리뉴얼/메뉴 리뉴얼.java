import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, Integer> map;
    static int[] max;
    static int l;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        l = course.length;
        
        map = new HashMap<>();
        max = new int[l];
        
        for(int i = 0; i < orders.length; i++) {
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            
            for(int j = 0; j < l; j++) {
                boolean[] visited = new boolean[c.length];
                comb(0, 0, course[j], j, "", c, visited);
            }
        }
        
        ArrayList<String> list = new ArrayList<>();
        // 답 정렬
        for(String s : map.keySet()) {
            for(int i = 0; i < l; i++) {
                if(s.length() == course[i] && max[i] == map.get(s) && max[i] > 1)
                    list.add(s);
            }
        }
        
        return list.stream().sorted().map(s -> s).toArray(String[]::new);
        
    }
    // 현재 메뉴 자리, 최대 메뉴 자리, 현재 문자열, 기존 문자열, 방문 여부
    public void comb(int cur, int cnt, int course, int j, String s, char[] c, boolean[] visited) {
        if(cnt == course) {
            map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
            max[j] = Math.max(max[j], map.get(s));
            // 맵에 횟수 추가
            // max 초기화
            return;
        }
        
        for(int i = cur; i < c.length; i++) {
            visited[i] = true;
            comb(i + 1, cnt + 1, course, j, s + c[i], c, visited);
        }
    }
}