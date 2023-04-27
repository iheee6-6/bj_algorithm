import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					list[i].add(j);
				}
			}
		}

		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[n + 1];
		check(arr[0]);

		boolean result = true;
		for (int i = 1; i < m; i++) {
			if (!visited[arr[i]]) {
				result = false;
				break;
			}
		}

		System.out.println(result == true ? "YES" : "NO");
	}

	static void check(int sidx) {
		visited[sidx] = true;
		for (int j = 0; j < list[sidx].size(); j++) {
			int line = list[sidx].get(j);
			if (!visited[line] && list[line].size() > 0) {
				check(line);
			}
		}
	}
}
