import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] participant = parseToArray(bf.readLine());
		String[] completion = parseToArray(bf.readLine());

		System.out.println(solution(participant, completion));

	}

	private static String[] parseToArray(String input) {

		StringTokenizer st = new StringTokenizer(input, "[] ,");
		List<String> list = new ArrayList<String>();

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		// .toArray()는 Object[]를 반환하므로 String[] 변수에 바로 담을 수 없음
		// 따라서 .toArray(T[] a)로 내가 반환받고 싶은 배열의 타입 정보를 파라미터로 넘겨야 함
		return list.toArray(new String[0]);
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";

		// 해쉬 맵 이름을 키로 하고 저장을 숫자로 함. 찾으면 하나씩 찾음
		HashMap<String, Integer> map = new HashMap<>();
		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}

		for (String c : completion) {
			map.put(c, map.getOrDefault(c, 0) - 1); // 존재하지 않는 참가자가 완주한 경우 방어
		}

		for (String key : map.keySet()) {
			if (map.get(key) > 0) {
				return key; // 완주하지 못한 선수는 1명 뿐이므로
			}
		}

		return answer;
	}

}