import java.util.*;
import java.util.Map.Entry;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> parking = new HashMap<>();
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        TreeMap<String, Integer> map = new TreeMap<>(comparator);
        for(String s : records) {
            String[] temp = s.split(" ");
            String[] hm = temp[0].split(":");
            int time = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
            if(temp[2].equals("IN")){
                parking.put(temp[1], time);
            }
            else{
                int parkingTime = time - parking.get(temp[1]);
                map.compute(temp[1], (k, v) -> (v == null) ? parkingTime : v + parkingTime);
                parking.remove(temp[1]);
            }
        }
        for(String s : parking.keySet()){
            if(!map.containsKey(s)) {
                map.put(s, (1439 - parking.get(s)));
            }
            else {
                Integer temp = map.get(s);
                map.put(s, temp + (1439 - parking.get(s)));
            }
        }
        for(String s : map.keySet()){
            if(map.get(s) <= fees[0]) {
                answer.add(fees[1]);
            }
            else{
                int fee = fees[1] + (int)Math.ceil((double)(map.get(s) - fees[0]) / fees[2]) * fees[3];
                answer.add(fee);
            }
            
        }
        return answer;
    }
}