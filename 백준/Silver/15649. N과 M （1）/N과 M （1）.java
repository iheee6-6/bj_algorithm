import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n + 1];
		arr = new int[m];
		dfs(0);

		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == m) {
			for (int idx : arr)
				sb.append(idx).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth]=i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

}
