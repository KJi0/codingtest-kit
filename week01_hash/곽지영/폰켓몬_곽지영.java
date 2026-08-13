import java.util.HashSet;

class 폰켓몬_곽지영 {

    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        return Math.min(set.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        int answer = solution(nums);

        System.out.println(answer);
    }
}