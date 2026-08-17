import java.util.*;

// 같은 이름을 가진 의상은 존재 x

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        
        for(int i = 0; i < clothes.length; ++i) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
            hs.add(clothes[i][1]);
        }
        
        for(String s : hs) {
            answer *= (hm.get(s) + 1);
        }
       
        return answer - 1;
    }
}