package algorithm;

import java.util.Arrays;

/** 
 * [전화번호 목록]
 * 1. 전화번호부를 정렬한다.
 * 2. 현재 번호가 다음 번호 접두사 인지 확인한다.
 * 
 * Time Complexity : O(N log N)
 * Space Complexity : O(N)
 */

class 전화번호_목록_오명헌 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length - 1; i++) {
        	if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}
