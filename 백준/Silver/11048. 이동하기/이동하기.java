import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, dp;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i + 1 < n) {
					dp[i + 1][j] = Math.max(arr[i + 1][j] + dp[i][j], dp[i + 1][j]);
				}
				if (i + 1 < n && j + 1 < m) {
					dp[i + 1][j + 1] = Math.max(arr[i + 1][j + 1] + dp[i][j], dp[i + 1][j + 1]);
				}
				if (j + 1 < m) {
					dp[i][j + 1] = Math.max(arr[i][j + 1] + dp[i][j], dp[i][j + 1]);
				}

			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}