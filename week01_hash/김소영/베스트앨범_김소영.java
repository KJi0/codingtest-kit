import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), "[], \"");

		List<String> genreList = new ArrayList<>();
		while (st.hasMoreTokens()) {
			genreList.add(st.nextToken());
		}
		String[] genres = genreList.toArray(new String[0]);

		st = new StringTokenizer(bf.readLine(), "[], ");
		int[] plays = new int[genres.length];
		for (int i = 0; i < plays.length; i++) {
			plays[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = solution(genres, plays);
		System.out.println(Arrays.toString(result));

	}

	public static int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, Integer> genre = new HashMap<String, Integer>();
		HashMap<String, List<Integer[]>> list = new HashMap<String, List<Integer[]>>();

		for (int i =0 ; i < genres.length; i++) {
			String g = genres[i];
			genre.put(g, genre.getOrDefault(g, 0) + plays[i]);
			list.putIfAbsent(g, new ArrayList<Integer[]>());
			list.get(g).add(new Integer[]{i, plays[i]});
		}
		
		List<String> keySet = new ArrayList<>(genre.keySet());
		keySet.sort((a, b) -> genre.get(b) - genre.get(a));
		
		List<Integer> resultList = new ArrayList<>();
		for (String g : keySet) {
		    List<Integer[]> songs = list.get(g);
		    songs.sort((a, b) -> a[1].equals(b[1]) ? a[0] - b[0] : b[1] - a[1]);
		    
		    resultList.add(songs.get(0)[0]);
	        if (songs.size() > 1) {
	            resultList.add(songs.get(1)[0]);
	        }
		}
		

		return resultList.stream().mapToInt(i -> i).toArray();
	}

}