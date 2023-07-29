import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        Arrays.sort(people);
        for(int i = people.length - 1; i >= index; i--){
            if(people[index] + people[i] <= limit){
                answer++;
                index++;
                continue;
            }
            else{
                answer++;
            }
        }
        return answer;
            
    }
//     public int solution(int[] people, int limit) {
//         int answer = 0;
//         int length = people.length;
        
//         Integer[] tmp = Arrays.stream(people)
//             .boxed()
//             .toArray(Integer[]::new);
//         Arrays.sort(tmp, Collections.reverseOrder());
        
//         int[] check = new int[length];
//         int[] num = new int[length];
//         for(int i = 0; i < length; i++){
//             for(int j = 0; j < length; j++){
//                 if(num[j] == 0){
//                     num[j] += tmp[i];
//                     check[j]++;
//                     break;
//                 }
//                 if(check[j] < 2 && num[j] + tmp[i] <= limit){
//                     num[j] += tmp[i];
//                     check[j]++;
//                     break;
//                 }
//             }
//         }
//         for(int i : num){
//             System.out.println(i);
//             //tmp[i] = people[i];
//         }
//         for(int i = 0; i < length; i++){
//             if(num[i] == 0)
//                 break;
//             answer++;
//         }
//         return answer;
//     }
}