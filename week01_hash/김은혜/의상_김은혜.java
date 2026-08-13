package week01_hash.김은혜;

import java.util.HashMap;

// 종류별 1가지 의상 착용 시, 서로 다른 옷의 조합의 수 리턴
// 2차원 배열 clothes: [의상명, 의상종류]
public class 의상_김은혜 {

    HashMap<String, Integer> count=new HashMap<>();

    public int solution(String[][] clothes) {
        int answer=1;

        for(String[] kind: clothes){
            if(count.containsKey(kind[1])){
                count.put(kind[1], count.get(kind[1])+1);
            } else{
                count.put(kind[1], 1);
            }
        }

        for(int c: count.values()){
            answer*=(c+1);
        }
        return answer-1;
    }

}
