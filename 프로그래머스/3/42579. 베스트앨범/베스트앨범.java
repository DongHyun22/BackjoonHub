import java.util.*;

class Music implements Comparable<Music>{
    int index;
    int plays;
    
    Music(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }
    
    public int compareTo(Music o) {
        if(this.plays == o.plays) {
            return this.index - o.index;
        }
        return o.plays - this.plays;
    }
    
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // map으로 수록 순서 정하기
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                continue;
            }
            map.put(genres[i], plays[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int totalPlays : list) {
            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                if(entry.getValue() == totalPlays) {
                    String g = entry.getKey();
                    // 장르에 맞는 걸 큐에 넣어 저장
                    PriorityQueue<Music> pq = new PriorityQueue<>();
                    for(int i = 0; i < genres.length; i++) {
                        if(g.equals(genres[i])) {
                            pq.add(new Music(i, plays[i]));
                        }
                    }
                    for(int i = 0; i < 2; i++) {
                        if(pq.isEmpty()) 
                            break;
                        temp.add(pq.poll().index);
                    }
                    
                }
            }
        }
        
        
        // 해당 장르의 Music객체 생성 후 우선순위 큐에 넣어 실행
        int size = temp.size();
        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}