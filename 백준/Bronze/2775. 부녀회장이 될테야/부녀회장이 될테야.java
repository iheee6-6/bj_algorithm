import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[][] dp;
		for (int i = 0; i < num; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			dp = new int[k + 1][n + 1];
			for (int j = 1; j < n + 1; j++) {
				dp[0][j] = j;
			}
			for (int j = 1; j < k + 1; j++) {
				for (int z = 1; z < n + 1; z++) {
					dp[j][z] = dp[j - 1][z] + dp[j][z - 1];
				}
			}

			System.out.println(dp[k][n]);

		}
	}
}