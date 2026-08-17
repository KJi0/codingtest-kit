package week01_hash.김은혜;

import java.util.*;

// 장르별 많이 재생된 노래 2개씩 모음 -> 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 리턴
// 많이 재생된 장르 -> 장르 내 많이 재생 -> 같으면 고유 번호 낮은 노래
// 장르 genres, 재생횟수 plays
public class 베스트앨범_김은혜 {

    Map<String, Integer> genre=new HashMap<>();
    Map<String, Integer> cnt1=new HashMap<>();
    Map<String, Integer> cnt2=new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {
        int[] answer=new int[plays.length];
        int idx=0;

        for(int i=0; i<genres.length; i++){
            if(genre.containsKey(genres[i])){
                genre.put(genres[i], genre.get(genres[i])+plays[i]);

                int idx1=cnt1.get(genres[i]);
                if(plays[idx1]<plays[i]){
                    cnt2.put(genres[i], idx1);
                    cnt1.put(genres[i], i);
                } else if(cnt2.get(genres[i])==null || plays[cnt2.get(genres[i])]<plays[i]){
                    cnt2.put(genres[i], i);
                }
            } else{
                genre.put(genres[i], plays[i]);
                cnt1.put(genres[i], i);
            }
        }

        List<String> key=new ArrayList<>(genre.keySet());
        key.sort((k1, k2) -> genre.get(k2).compareTo(genre.get(k1)));

        for(String k: key){
            answer[idx++]=cnt1.get(k);
            if(cnt2.containsKey(k)){
                answer[idx++]=cnt2.get(k);
            }
        }

        return Arrays.copyOf(answer, idx);
    }

}
