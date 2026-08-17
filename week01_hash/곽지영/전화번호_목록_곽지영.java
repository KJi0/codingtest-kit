import java.util.Arrays;
import java.util.HashSet;

class 전화번호_목록_곽지영 {

    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        for (String num : phone_book) set.add(num);

        for (String num : phone_book) {
            for (int i = 0; i < num.length(); i++) {
                String pre = num.substring(0, i);

                if (set.contains(pre)) return false;
            }
        }

        return true;

        /* 문자열 정렬 풀이
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return true;
         */
    }

    public static void main(String[] args) {
        String[] phone_book = {"123","456","789"};
        boolean answer = solution(phone_book);

        System.out.println(answer);
    }
}