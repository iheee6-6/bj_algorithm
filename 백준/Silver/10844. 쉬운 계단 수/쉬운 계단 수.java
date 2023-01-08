
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 어렵
	/*
	 * dp[i][j] : i 길이의 수 마지막 부분이 j일 때 계단수
	 * 
	 * 
	 * 예를 들어 길이가 3이고 끝부분이 5일 때 계단수는 길이가 2이고 4로 끝나는 계단수, 길이가 2이고 6으로 끝나는 계단수의 합입니다.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n][10];
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][9] = dp[i - 1][8];
			for (int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n - 1][i];
		}
		System.out.println(sum % 1000000000);
	}
}