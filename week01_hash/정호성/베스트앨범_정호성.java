import java.util.*;

class Solution {
    Map<String, Integer> hm = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        List<Music> musicList = new ArrayList<>();
        
        for(int i = 0; i < genres.length; ++i) {
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
            
            musicList.add(new Music(genres[i], plays[i], i));
        }
        
        musicList.sort((a, b) -> {
            // 1. 속한 노래가 많이 재생된 장르
            int genreComp = Integer.compare(
                hm.get(b.genre), hm.get(a.genre)
            );
            
            if(genreComp != 0) {
                return genreComp;
            }
            
            // 2. 장르가 같다면 곡 재생수 내림차순
            int playComp = Integer.compare(
                b.play, a.play
            );
            
            if(playComp != 0) {
                return playComp;
            }
            
            // 3. 둘 다 같으면, 고유번호는 오름차순
            return Integer.compare(a.number, b.number);
        });
        
        Map<String, Integer> count = new HashMap<>();
        
        for(Music music : musicList) {
            int cnt = count.getOrDefault(music.genre, 0);
            
            if(cnt >= 2) {
                continue;
            }
            
            answer.add(music.number);
            count.put(music.genre, cnt + 1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Music {
        String genre;
        int play;
        int number;
        
        Music(String genre, int play, int number) {
            this.genre = genre;
            this.play = play;
            this.number = number;
        }
    }
}