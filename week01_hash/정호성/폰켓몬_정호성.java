import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = 0;
        
        Set<Integer> hs = new HashSet<>();
    
        
        for(int i : nums) {
            hs.add(i);
            size++;
        }
        
        if(size / 2 < hs.size()) {
            answer = size / 2;
        } else {
            answer = hs.size();
        }
        return answer;
    }
}