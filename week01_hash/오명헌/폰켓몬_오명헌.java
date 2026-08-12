package algorithm;

import java.util.HashSet;

/** 폰켓몬
 * Idea
 * 1. nums를 순회하며 hashset에 폰켓몬을 저장한다.
 * 2. hashset의 사이즈가 n/2 보다 크다면 answer = n/ 2 작다면 answer = hashset 사이즈
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

class 폰켓몬_오명헌 {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int n : nums) set.add(n);
        return set.size() >= (nums.length / 2) ? nums.length / 2 : set.size();
    }
}