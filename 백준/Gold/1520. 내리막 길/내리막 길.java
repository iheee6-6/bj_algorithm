import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] check;
	static int[][] dp;
	static long result = 0;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int min, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int x = Integer.parseInt(st.nextToken());
				arr[i][j] = x;
				dp[i][j]=-1;
			}
		}

		System.out.println(dfs(N - 1, M - 1));

	}

	static int dfs(int x, int y) {
		if (x == 0 && y == 0)
			return 1;
		if (dp[x][y] == -1) {
			dp[x][y]=0;
			for (int i = 0; i < 4; i++) {
				min = arr[x][y];
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx < N && yy < M & xx >= 0 && yy >= 0) {
					if (min < arr[xx][yy]) {
						dp[x][y] += dfs(xx, yy);
					}
				}
			}
		}
		return dp[x][y];
	}

}