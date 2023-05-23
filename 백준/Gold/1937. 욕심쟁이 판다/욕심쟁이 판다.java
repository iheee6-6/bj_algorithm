import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;
	static boolean[][] visited;
	static int n, result = 1;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		dp = new int[n][n];
		visited = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, find(i, j));
			}
		}

		System.out.println(result);
	}

	static int find(int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || yy < 0 || xx > n - 1 || yy > n - 1)
				continue;
			if (arr[xx][yy] > arr[x][y]) {
				dp[x][y] = Math.max(dp[x][y], find(xx, yy) + 1);
			}
		}
		return dp[x][y];
	}
}
