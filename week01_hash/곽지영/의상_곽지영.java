import java.util.HashMap;

class 의상_곽지영 {

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int sum = 1;

        for (int val : map.values())
            sum *= (val + 1);

        return sum - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };
        int answer = solution(clothes);

        System.out.println(answer);
    }
}
