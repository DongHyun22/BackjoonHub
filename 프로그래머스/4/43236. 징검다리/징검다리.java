import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        // 이분탐색
        // mid의 값은 각 지점 사이의 거리의 최솟값
        // 최솟값보다 작으면 바위 없애기
        // 전체를 구한 후 없앤 바위수를 구해
        // n보다 작거나 같으면 -> mid 올리기
        // n보다 크면 -> mid 내리기
        
        int left = 0;
        int right = distance;
        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            int start = 0;
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - start >= mid) {
                    start = rocks[i];
                }
                else {
                    count++;
                }
            }
            if(distance - start < mid)
                count++;
            
            if(count <= n) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}