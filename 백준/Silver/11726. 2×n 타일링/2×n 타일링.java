import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer dp[] = new Integer[1001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n > 3) {
			for (int i = 4; i < n + 1; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2] )%10007;
			}
		}
		System.out.println(dp[n]);
	}

}