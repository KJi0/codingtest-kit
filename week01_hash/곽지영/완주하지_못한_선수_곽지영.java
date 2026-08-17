import java.util.HashMap;

class 완주하지_못한_선수_곽지영 {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String name : completion) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : participant) {
            int val = map.getOrDefault(name, 0);

            if (val == 0) return name;
            else map.put(name, val - 1);
        }

        return "";
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = solution(participant, completion);

        System.out.println(answer); // leo
    }
}