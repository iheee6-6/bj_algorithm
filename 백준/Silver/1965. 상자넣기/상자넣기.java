import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			for (int j = i; j >=0; j--) {
				if (arr[j] < arr[i]) {
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max+1);
	}

}
