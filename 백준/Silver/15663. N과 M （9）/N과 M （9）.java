import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static int[] resultArr;
	static LinkedHashSet<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		visited = new boolean[n];
		resultArr = new int[m];
		answer = new LinkedHashSet<>();
		dfs(0, 0);

		answer.forEach(System.out::println);

	}

	static void dfs(int idx, int depth) {
		if (depth == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(resultArr[i]).append(" ");
			}
			answer.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i]=true;
				resultArr[depth]=arr[i];
				dfs(i,depth+1);
				visited[i]=false;
			}
		}
	}
}
