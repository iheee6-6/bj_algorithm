import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int arr[][];
	static long dp[][];
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		dp = new long[n + 1][n + 1];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1]=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int plus = arr[i][j];
				if(plus==0) break;
				if(i+plus<=n) dp[i+plus][j]+=dp[i][j];
				if(j+plus<=n) dp[i][j+plus]+=dp[i][j];
			}
		}
		System.out.println(dp[n][n]);
	}

	static void dpFunc(int x, int y) {
		dp[x][y]++;
		if (x == n && y == n)
			return;
		if (x + arr[x][y] <= n)
			dpFunc(x + arr[x][y], y);
		if (y + arr[x][y] <= n)
			dpFunc(x, y + arr[x][y]);
	}
}
