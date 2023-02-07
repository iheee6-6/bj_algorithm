import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, dp;
	static int count = 0, num, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		arr = new int[num + 1];
		dp = new int[sum+1];
		for (int i = 1; i < num + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0]=1;
		for (int i = 1; i < num + 1; i++) {
			for (int j = arr[i]; j <= sum; j++) {
				dp[j]=dp[j]+dp[j-arr[i]];
			}
		}
		System.out.println(dp[sum]);
	}

}