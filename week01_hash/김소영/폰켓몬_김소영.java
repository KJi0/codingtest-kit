import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), "[],");

		List<Integer> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		System.out.println(solution(nums));

	}

	public static int solution(int[] nums) {
		int answer = 0;
		int num = nums.length;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		// n/2마리를 골라야 한다면
		int cnt = map.keySet().size();
		answer = cnt > num/2 ? num/2 : cnt;
		

		return answer;
	}

}