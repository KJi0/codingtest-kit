/**
 * [베스트앨범]
 * Algorithm : 해시, 우선순위 큐
 * Time Complexity : O(N log N)
 * Space Complexity : O(N)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Music implements Comparable<Music>{
	int id;
	int count;
	
	public Music (int id, int count) {
		this.id = id;
		this.count = count;
	}

	@Override
	public int compareTo(Music o) {
		if (this.count == o.count) {
			return this.id - o.id;
		}
		
		return o.count - this.count;
	}
}

class Genre implements Comparable<Genre>{
	String name;
	int total;
	
	public Genre(String name, int total) {
		this.name = name;
		this.total = total;
	}

	@Override
	public int compareTo(Genre o) {
		return o.total - this.total;
	}
}

class 베스트앨범_오명헌 {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> list = new ArrayList<Integer>();
		
		HashMap<String, Integer> genreMap = new HashMap<String, Integer>();
		
		HashMap<String, PriorityQueue<Music>> musicMap = new HashMap<String, PriorityQueue<Music>>();
		
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			Music music = new Music(i, play);
			
			genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
			
			if (!musicMap.containsKey(genre)) {
				musicMap.put(genre, new PriorityQueue<Music>());
			}
			
			musicMap.get(genre).add(music);
		}
		
		PriorityQueue<Genre> genrePq = new PriorityQueue<Genre>();
		
		for (String name : genreMap.keySet()) {
			genrePq.add(new Genre(name, genreMap.get(name)));
		}
		
		while (!genrePq.isEmpty()) {
			String genre = genrePq.poll().name;
			int cnt = 0;
			
			while (!musicMap.get(genre).isEmpty() && cnt < 2) {
				cnt++;
				list.add(musicMap.get(genre).poll().id);
			}
		}
		
		int[] answer = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}