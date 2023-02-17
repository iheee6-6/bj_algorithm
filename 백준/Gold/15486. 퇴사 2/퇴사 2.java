import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Work {
	int day;
	int cash;

	public Work(int day, int cash) {
		this.day = day;
		this.cash = cash;
	}
}

public class Main {
	static int n;
	static int[] dp;
	static Work[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new Work[n + 2];
		dp = new int[n + 2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int cash = Integer.parseInt(st.nextToken());
			Work w = new Work(day, cash);
			arr[i] = w;
		}
		int max = 0;
		for (int i = 1; i < n + 2; i++) {
			if (max < dp[i])
				max = dp[i];
			if (i < n + 1) {
				Work w = arr[i];
				if (i + w.day <= n + 1)
					dp[i + w.day] = Math.max(max + w.cash, dp[i + w.day]);
			}
		}
		System.out.println(max);
	}

}