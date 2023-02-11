import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// -1 -1 -1 이 나오면 종료
			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append('\n');

		}

		System.out.println(sb);
	}

	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (a > 20 || b > 20 || c > 20)
			return w(20, 20, 20);
		if (a < b && b < c) {
			if (dp[a][b][c] != 0) {
				return dp[a][b][c];
			} else
				return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

		}
		if (dp[a][b][c] != 0) {
			return dp[a][b][c];
		} else
			return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

	}

}
