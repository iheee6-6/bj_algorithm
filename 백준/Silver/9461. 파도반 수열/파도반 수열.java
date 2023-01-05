import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt + 1];
		Long[] dp = new Long[101];
		for (int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[0] = 0L;
			dp[1] = 1L;
			if (arr[i] > 1) {
				dp[2] = 1L;
			}
			if (arr[i] > 2) {
				dp[3] = 1L;
			}
			for(int j=4;j<arr[i]+1;j++) {
				dp[j]=dp[j-2]+dp[j-3];
			}
			System.out.println(dp[arr[i]]);
		}
	}
}
