import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] dp;
	static int[] score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		dp = new Integer[cnt + 1];
		score = new int[cnt + 1];
		for (int i = 1; i < cnt + 1; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = score[0];	// 디폴트값이 null이므로 0으로 초기화 해주어야한다.
		dp[1] = score[1];
		
		if(cnt >= 2) {
			dp[2] = score[1] + score[2];
		}
		
		System.out.println(find(cnt));
	}

	static int find(int N) {
		// 아직 탐색하지 않는 N번째 계단일 경우
		if(dp[N] == null) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + score[N - 1]) + score[N];
		}
		
		return dp[N];
	}
}