import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	static int[] dp = new int[100001];
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs(n);
	}

	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		dp[n] = 1;
		while (!q.isEmpty()) {
			int idx = q.poll();
			if(idx==k) {
				System.out.println(dp[idx]-1);
				return;
			}
			if (idx - 1 >= 0 && dp[idx - 1] == 0) {
				dp[idx - 1] = dp[idx] + 1;
				q.add(idx - 1);
			}
			if (idx + 1 <= 100000 && dp[idx + 1] == 0) {
				dp[idx + 1] = dp[idx] + 1;
				q.add(idx + 1);
			}
			if (idx * 2 <= 100000 && dp[idx * 2] == 0) {
				dp[idx * 2] = dp[idx] + 1;
				q.add(idx * 2);
			}
		}
	}
}
