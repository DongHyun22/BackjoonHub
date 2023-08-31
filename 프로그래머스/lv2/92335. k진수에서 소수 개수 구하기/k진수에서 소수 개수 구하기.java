import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s = Integer.toString(n, k);
        
        
        ArrayList<String> list = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i == 0) {
                temp += c;
                continue;
            }
            if(i == s.length()-1){
                if(c == '0'){
                    if(!(temp.equals(""))){
                        list.add(temp);
                        break;
                    }
                }
                temp += c;
                list.add(temp);
                break;
            }
            if(c == '0' && !(temp.equals(""))){
                list.add(temp);
                temp = "";
            }
            else if(c != '0'){
                temp += c;
            }
        }
        
        
        for(String r : list){
            long i = Long.parseLong(r);
            if(checkPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    public boolean checkPrime(long num){
        if(num <= 1)
            return false;
        if(num == 2)
            return true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}