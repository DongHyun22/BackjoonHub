import java.util.*;
import java.time.*;

class Music implements Comparable<Music>{
    int playTime;
    String title;
    int count;
    
    Music(int playTime, String title, int count) {
        this.playTime = playTime;
        this.title = title;
        this.count = count;
    }
    
    public int compareTo(Music m) {
        if(this.title.length() == m.title.length()) {
            return this.count - m.count;
        }
        return m.title.length() - this.title.length();
    }
}

class FF {
    int t;
    String str;
    
    FF(int t, String str) {
        this.t = t;
        this.str = str;
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxPlayTime = -1;
        
        m = changeCH(m);
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] tmp = musicinfos[i].split(",");
            
            // 재생된 음 찾기
            FF melody = findMelody(tmp);
            
            // 음에 기억한 음이 있으면 큐에 저장
            if(melody.str.contains(m) && melody.t > maxPlayTime) {
                answer = tmp[2];
                maxPlayTime = melody.t;
            }
        }
        
        if(maxPlayTime == -1)
            answer = "(None)";
        return answer;
    }
    
    public FF findMelody(String[] tmp) {
        LocalTime start = LocalTime.parse(tmp[0]);
        LocalTime end = LocalTime.parse(tmp[1]);
        
        Duration d = Duration.between(start, end);
        int t = (int)Math.abs(d.toMinutes());
        
        char[] melody = changeCH(tmp[3]).toCharArray();
        String str = "";
        for(int i = 0; i < t; i++) {
            str += melody[i % melody.length];
        }
    
        return new FF(t, str);
    }
    
    public String changeCH(String oldMelody) {
        oldMelody = oldMelody.replaceAll("B#", "Z");
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");
        return newMelody;
    }
    
}