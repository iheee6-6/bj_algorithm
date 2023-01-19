
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static ArrayList<String> ch, home;
	static boolean[] chvisited;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		ch = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					home.add(i + " " + j);
				else if (arr[i][j] == 2)
					ch.add(i + " " + j);
			}
		}
		chvisited = new boolean[ch.size()];
		back(0, 0);
		System.out.println(result);
	}

	static void back(int count, int idx) {
		if (count == m) {
			int total = 0;
			for (int i = 0; i < home.size(); i++) {
				int sum = Integer.MAX_VALUE;
				String[] homearr = home.get(i).split(" ");
				for (int j = 0; j < ch.size(); j++) {
					if (chvisited[j] == true) {
						String[] charr = ch.get(j).split(" ");
						int dist = Math.abs(Integer.parseInt(homearr[0]) - Integer.parseInt(charr[0])) + Math.abs(Integer.parseInt(homearr[1]) - Integer.parseInt(charr[1]));
						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			result = Math.min(total, result);
			return;
		}

		for (int i = idx; i < ch.size(); i++) {
			if (chvisited[i] == false) {
				chvisited[i] = true;
				back(count + 1, i + 1);
				chvisited[i] = false;
			}
		}
	}

}