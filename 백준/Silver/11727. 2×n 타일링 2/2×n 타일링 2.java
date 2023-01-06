import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] dp = new int[cnt+1];
		dp[0]=1;
		dp[1]=3;
		for (int i = 2; i < cnt; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2])%10007;
		}
		System.out.println(dp[cnt-1]);
	}
}