import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), "[], \"");

		List<String> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		String[] nums = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}

		System.out.println(solution(nums));

	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		HashMap<String, String> map = new HashMap<String, String>();

		for (String num : phone_book) {
			map.put(num, num);
		}

		for (String num : phone_book) {
			for (int i =1; i < num.length(); i++) {
				String str = num.substring(0, i);
				if(map.containsKey(str))
					return false;
			}
		}

		return answer;
	}

}