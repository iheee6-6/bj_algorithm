import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long ret;
	static int[] arr;
	static int[] dp;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1];
		sum = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + arr[i];
		}

		// 나올 수 없는 경우
		if (sum[n] % 4 > 0)
			ret = 0;
		else {
			// 누적합이 0인 경우
			if (sum[n]==0) {
				long zero = 0;
				for (int i = 1; i <= n; i++)
					zero += sum[i]!=0?0:1;

				ret = (zero - 1) * (zero - 2) * (zero - 3) / 6;
			}

			// DP
			else {
				dp[0] = 1;
				int val = sum[n] / 4;

				for (int i = 1; i <= n; i++) {
					int t = sum[i] / val;
					if (sum[i] % val != 0 || t < 1 || t > 4)
						continue;

					dp[t] += dp[t - 1];
				}

				ret = dp[4];
			}
		}
		
		System.out.println(ret);
	}

}
