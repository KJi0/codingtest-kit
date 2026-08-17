package algorithm;

import java.util.HashMap;

/**
 * [완주하지 못한 선수]
 * Idea
 * 1. 참가자들의 이름으로 map을 만든다.
 * 2. 동명이인이 있을 수 있으므로 value 값을 int로 한다.
 * 3. 완주한 사람들의 이름을 순회하며 해당하는 value 값을 찾아 -1 한다.
 * 4. map을 순회하며 0이 아닌 값을 answer에 담는다.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

class 완주하지_못한_선수_오명헌 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String name : participant) {
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		for (String name : completion) {
			map.put(name, map.get(name) - 1);
		}

		for (String name : participant) {
			if (map.get(name) != 0) {
				answer = name;
			}
		}

		return answer;
	}
}