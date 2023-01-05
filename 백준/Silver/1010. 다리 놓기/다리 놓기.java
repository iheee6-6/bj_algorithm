import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(comb(m, n)).append('\n');
		}
		System.out.println(sb);
	}

	static int comb(int m, int n) {
		if (dp[m][n] > 0)
			return dp[m][n];
		if (m == n || n == 0)
			return dp[m][n] = 1;
		return dp[m][n]=comb(m - 1, n - 1) + comb(m - 1, n);

	}
}
