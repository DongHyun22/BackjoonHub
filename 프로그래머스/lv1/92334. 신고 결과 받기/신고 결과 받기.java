import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> hs = new HashSet<>();
        hs.addAll(Arrays.asList(report));
        int[] temp = new int[id_list.length];
        ArrayList<String>[] memo = new ArrayList[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            memo[i] = new ArrayList<>();
        }
        for (String s : hs){
            StringTokenizer st = new StringTokenizer(s);
            int i = Arrays.asList(id_list).indexOf(st.nextToken());
            String user = id_list[Arrays.asList(id_list).indexOf(st.nextToken())];
            memo[i].add(user);
            temp[Arrays.asList(id_list).indexOf(user)]++;
        }
        // temp에는 각 인덱스 별 신고 당한 획수
        // memo는 누가 누굴 신고했는지 기록되어있음
        ArrayList<String> stop = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++){
            if(temp[i] >= k){
                stop.add(id_list[i]);
            }
        }
        for(String s : stop){
            for (int i = 0; i < id_list.length; i++){
                if(memo[i].contains(s)){
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}