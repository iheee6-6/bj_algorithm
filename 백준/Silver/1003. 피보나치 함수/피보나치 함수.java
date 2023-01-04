import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		dp = new Integer[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for (int i = 0; i < cnt; i++) {
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}

	static Integer[] fibonacci(int n) {
		if (dp[n][0] == null || dp[n][1] == null) {
			dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		return dp[n];
	}
}