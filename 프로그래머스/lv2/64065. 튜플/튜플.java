import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "&");
        String[] arr = s.split("&");
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(String t : arr){
            String[] temp = t.split(",");
            for(int i = 0; i < temp.length; i++){
                int n = Integer.parseInt(temp[i]);
                if(!list.contains(n)){
                    list.add(n);
                }
            }
        }
        return list;
    }
}