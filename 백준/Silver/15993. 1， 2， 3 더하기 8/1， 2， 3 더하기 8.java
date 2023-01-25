import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[][] dp = new long[100001][2];
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][0] = 1;
		dp[3][1] = 2;//홀
		dp[3][0] = 2;//짝
		for (int i = 4; i < 100001; i++) {
			dp[i][0]=(dp[i-3][1]+dp[i-2][1]+dp[i-1][1])%1000000009;
			dp[i][1]=(dp[i-3][0]+dp[i-2][0]+dp[i-1][0])%1000000009;
		}

		for (int i = 0; i < n; i++) {
			int num = stoi(br.readLine());
			
			sb.append(dp[num][1]+" "+dp[num][0]+ "\n");
		}
		System.out.println(sb);
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
