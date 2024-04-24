import java.util.*;

class Solution {
    static String[] user_id;
    static String[] banned_id;
    static HashSet<HashSet<String>> set;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        this.user_id = user_id.clone();
        this.banned_id = banned_id.clone();
        set = new HashSet<>();
        
        comb(0, new HashSet<>());
        answer = set.size();
        return answer;
    }
    
    public void comb(int count, HashSet<String> temp) {
        if(count == banned_id.length) {
            set.add(new HashSet<>(temp));
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(temp.contains(user_id[i]))
                continue;
            if(check(user_id[i], banned_id[count])) {
                temp.add(user_id[i]);
                comb(count + 1, temp);
                temp.remove(user_id[i]);
            }
        }
    }
    
    public boolean check(String user, String ban) {
        boolean flag = true;
        if(user.length() != ban.length())
            return false;
        char[] u = user.toCharArray();
        char[] b = ban.toCharArray();
        for(int i = 0; i < u.length; i++) {
            if(b[i] == '*')
                continue;
            if(u[i] != b[i])
                flag = false;
        }
        return flag;
    }
    
}