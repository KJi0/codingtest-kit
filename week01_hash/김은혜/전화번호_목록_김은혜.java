package week01_hash.김은혜;

import java.util.HashMap;

//전화번호가 담긴 배열 phone_book 중 특정 번호가 다른 번호의 접두어인 경우 false
public class 전화번호_목록_김은혜 {

    HashMap<String, Integer> book=new HashMap<>();

    public boolean solution(String[] phone_book) {

        for(String p: phone_book){
            book.put(p, 1);
        }

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
//                substring 시 끝 인덱스는 포함되지 않음
//                -> 중복 번호 없으므로 자기자신 거를 수 있음
                if(book.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }

        return true;
    }
}
