import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int max = -1;
        
        Set<String> hs = new HashSet<>();
        Set<Integer> sizes = new HashSet<>();
        
        for(String s : phone_book) {
            hs.add(s);
            
            if(s.length() > max) {
                sizes.add(s.length());
            }
        }
        
        for(String s : phone_book) {
                            
            for(Integer i : sizes) {
                if(s.length() <= i) continue;
                
                if(hs.contains(s.substring(0,i))) {
                    answer = false;
                    break;
                }
            }
            if(answer == false) break;
        }
        
        
        return answer;
    }
}