import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class 베스트앨범_곽지영 {
    static class Song {
        int idx; int play;

        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, List<Song>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);

            if (!songs.containsKey(genres[i])) songs.put(genres[i], new LinkedList<>());
            songs.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> popularGen = new ArrayList<>(total.keySet());
        popularGen.sort((o1, o2) -> total.get(o2).compareTo(total.get(o1)));

        List<Integer> answerList = new ArrayList<>();

        // 한 줄 람다는 return 생략 가능, 여러 줄 람다는 return 필요
        for (String gen : popularGen) {
            songs.get(gen).sort((o1, o2) -> {
                if (o2.play != o1.play) return Integer.compare(o2.play, o1.play);
                else return Integer.compare(o1.idx, o2.idx);
            });

            for (int i = 0; i < Math.min(2, songs.get(gen).size()); i++) {
                answerList.add(songs.get(gen).get(i).idx);
            }
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = solution(genres, plays);

        System.out.println(answer);
    }
}