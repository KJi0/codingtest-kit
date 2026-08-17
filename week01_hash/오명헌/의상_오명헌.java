package algorithm;

import java.util.HashMap;

/**
 * [의상]
 * Idea
 * 1. HashMap에 < 의상의 종류, 개수 > 으로 저장한다.
 * 2. 의상의 종류 개수 + 1(그 의상을 안 입는 경우) 을 구하고 곱한다.
 * 3. 아무 의상도 안 입는 경우 -1 을 뺀다.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class 의상_오명헌 {
	public int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String[] s : clothes) {
			map.put(s[1], map.getOrDefault(s[1], 1) + 1);
		}
		
		int answer = 1;
		
		for (int k : map.values()) answer *= k;
		
		return answer - 1;
	}
}