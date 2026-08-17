import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        
        for(String s : participant) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        
        for(String s : completion) {
            if(hm.get(s) == 1) {
                hm.remove(s);
            } else {
                hm.put(s, hm.get(s) - 1);
            }
        }
        
        answer = hm.keySet().iterator().next();
        
        return answer;
    }
}