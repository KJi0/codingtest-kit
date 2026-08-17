package week01_hash.김은혜;

import java.util.HashMap;

// n마리(짝수) 포켓몬 중 2/n 마리 선택 시, 가장 많은 종류를 선택했을 때 종류 개수 리턴
public class 폰켓몬_김은혜 {

    HashMap<Integer, Integer> kind=new HashMap<>();

    public int solution(int[] nums) {
        int answer = 0;
        int opt=0;

        for(int i=0; i<nums.length; i++){
            if(!kind.containsKey(nums[i])){
                opt++;
                kind.put(nums[i], 1);
            } else{
                kind.put(nums[i], kind.get(nums[i])+1);
            }
        }

        int total=nums.length;
        if(opt>=total/2){
            answer=total/2;
        } else{
            answer=opt;
        }

        return answer;
    }

}