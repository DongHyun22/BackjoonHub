import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayDeque<String> cache = new ArrayDeque<>();
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(int i = 0; i < cities.length; i++){
            String city = cities[i];
            boolean flag = true;
            for(String s : cache){
                if(s.equalsIgnoreCase(city)) {
                    cache.remove(s);
                    cache.add(city);
                    answer += 1;
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(!(cache.isEmpty()) && cache.size() >= cacheSize){
                    cache.removeFirst();
                    cache.add(city);
                }
                else{
                    cache.add(city);
                }
                answer += 5;
            }
        }
    return answer;
}
}