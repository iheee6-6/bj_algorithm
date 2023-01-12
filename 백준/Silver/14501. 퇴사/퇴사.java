import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[][] schedule;
	static int[] dp;
	static int result, max;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		schedule = new int[n][2];
		dp = new int[n+1];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if(i+schedule[i][0]<=n) {
				dp[i+schedule[i][0]]=Math.max(dp[i+schedule[i][0]], dp[i]+schedule[i][1]);
			}
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[n]);

	}

	static void dpfc(int start) {
		int idx = start + schedule[start][0];
		if (idx > n) {
			if (max < result)
				max = result;
			return;
		} else if (idx == n) {
			result += schedule[start][1];
			if (max < result)
				max = result;
			return;
		} else {
			if(idx+1<n&&schedule[idx+1][1]>schedule[start+1][1]) {
				result += schedule[start+1][1];
				idx = start+1+schedule[start+1][0];
				dpfc(idx);
			}else {
				result += schedule[start][1];
				dpfc(idx);
			}
		}

	}
}