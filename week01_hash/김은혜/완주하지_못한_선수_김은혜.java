package week01_hash.김은혜;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 마라톤 참여한 선수 particpant, 완주한 선수 completion
// 완주하지 못한 선수 이름 return
// completion 길이 = participant-1
public class 완주하지_못한_선수_김은혜 {

    HashMap<String, Integer> runners=new HashMap<>();

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        for(String p: participant){
            if(runners.containsKey(p)){
                runners.put(p, runners.get(p)+1);
            } else{
                runners.put(p, 1);
            }
        }

        for(String c: completion){
            int cnt=runners.get(c);
            if(cnt>1){
                runners.put(c, runners.get(c)-1);
            } else{
                runners.remove(c);
            }
        }

        for(String key: runners.keySet()){
            answer=key;
        }

        return answer;
    }

}