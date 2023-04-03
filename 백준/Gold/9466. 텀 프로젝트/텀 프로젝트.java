import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, Integer> map;
	static int donePeople = 0;
	static int people;
	static boolean visited[], done[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			map = new HashMap<>();
			people = Integer.parseInt(br.readLine());
			visited = new boolean[people + 1];
			done = new boolean[people + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < people + 1; j++) {
				map.put(j, Integer.parseInt(st.nextToken()));
			}

			donePeople = 0;

			for (int j = 1; j < people + 1; j++) {
				if (!done[j])
					check(j);
			}
			sb.append(people-donePeople+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void check(int idx) {
		if(done[idx]) return;
		if(visited[idx]) {
			donePeople++;
			done[idx]=true;
		}
		visited[idx]=true;
		check(map.get(idx));
		visited[idx]=false;
		done[idx]=true;
	}

}
