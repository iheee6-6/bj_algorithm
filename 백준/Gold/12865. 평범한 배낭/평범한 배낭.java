import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
	static int v, k, result;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[v+1][2];
		dp = new int[v+1][k+1];
		for (int i = 1; i <= v; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=v;i++) {
			for(int j=1;j<=k;j++) {
				dp[i][j]=dp[i-1][j];
				if(j-arr[i][0]>=0) {
					dp[i][j]= Math.max(dp[i-1][j],dp[i-1][j-arr[i][0]]+arr[i][1]);
				}
			}
		}
		System.out.println(dp[v][k]);
	}


}