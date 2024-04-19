import java.util.*;

class Discount {
    int r;
    int result;
    
    Discount(int r, int result) {
        this.r = r;
        this.result = result;
    }
}

class Solution {
    static int n;
    static int m;
    static int[] off = {40, 30, 20, 10};
    static double[] d = {0.6, 0.7, 0.8, 0.9};
    static int[][] userInfo;
    static int[] emo;
    static Discount[] price;
    static int maxJoin = 0;
    static int maxTotal = 0;
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        price = new Discount[m];
        emo = emoticons.clone();
        userInfo = new int[n][2];
        for(int i = 0; i < n; i++) {
            userInfo[i] = users[i].clone();
        }
        per(0);
        int[] answer = new int[] {maxJoin, maxTotal};
        return answer;
    }
    public void per(int count) {
        if(count == m) {
            // 할인 모두 적용했으면 계산으로
            calc();
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            price[count] = new Discount(off[i], (emo[count] * (100 - off[i]) / 100));
            per(count+1);
        }
    }
    
    public void calc() {
        int join = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            int rate = userInfo[i][0];
            int lim = userInfo[i][1];
            int sum = 0;
            for(int j = 0; j < m; j++) {
                Discount temp = price[j];
                if(rate <= temp.r) {
                    sum += temp.result;
                }
            }
            // 합이 일정 가격 이상이 되면
            if(lim <= sum) {
                join++;
            }
            else {
                total += sum;
            }
        }
        if(join == maxJoin) {
            if(total > maxTotal) {
                maxTotal = total;
            }
        }
        else if(join > maxJoin) {
            maxJoin = join;
            maxTotal = total;
        }
    }
}