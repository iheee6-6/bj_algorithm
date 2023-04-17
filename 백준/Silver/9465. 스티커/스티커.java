import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[2][n+1];
			dp = new int[2][n+1];
			StringTokenizer st;
			for (int x = 0; x < 2; x++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n+1; j++) {
					arr[x][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1]=arr[0][1];
			dp[1][1]=arr[1][1];
			
			for(int j=2;j<n+1;j++) {
				dp[0][j]=Math.max(dp[1][j-2],dp[1][j-1])+arr[0][j];
				dp[1][j]=Math.max(dp[0][j-2],dp[0][j-1])+arr[1][j];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}

	}
	

}
