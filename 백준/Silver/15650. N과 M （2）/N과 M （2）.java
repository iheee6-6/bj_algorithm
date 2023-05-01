import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		visited = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[0] = i;
			dfs(i, 1);
		}

		System.out.println(sb);

	}

	static void dfs(int idx, int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx + 1; i < n + 1; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);

		}
	}
}
