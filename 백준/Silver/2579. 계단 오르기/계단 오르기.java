import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dp;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());

		arr = new int[cnt + 1];
		for (int i = 1; i <= cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[cnt + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = arr[1];
		if (cnt >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		find(cnt);
		System.out.println(dp[cnt]);
	}

	static int find(int n) {
		if (dp[n] == -1) {
			dp[n] = Math.max(find(n - 2), find(n - 3) + arr[n - 1]) + arr[n];
		}
		return dp[n];
	}
}