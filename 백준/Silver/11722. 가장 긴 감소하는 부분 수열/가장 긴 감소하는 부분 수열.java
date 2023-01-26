import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class Main {
	static int num, max;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		arr = new int[num];
		dp = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1;
		for (int i = 1; i < num; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

		}
		OptionalInt ans = Arrays.stream(dp).max();
		System.out.println(ans.getAsInt());
	}
}