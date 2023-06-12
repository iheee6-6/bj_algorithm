import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] nArr, mArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nArr = new int[n+1];
		mArr = new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i =1; i <= m; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nArr);
		Arrays.sort(mArr);

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				//i번 남자와 j번 여자 커플 매칭
				dp[i][j] = dp[i - 1][j - 1] + Math.abs(nArr[i] - mArr[j]);
				//남자가 더 많으면 추가된 i번 남자 솔로
				if (i > j) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				//여자가 더 많으면 추가된 j번 여자 솔로
				else if (i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
