import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = stoi(br.readLine());
		long[][] dp = new long[1001][1001];
		dp[1][1]=1;
		dp[2][1]=1;
		dp[2][2]=1;
		dp[3][1]=1;
		dp[3][2]=2;
		dp[3][3]=1;
		for(int i=4;i<1001;i++) {
			for(int j=2;j<i;j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-2][j-1]+dp[i-3][j-1])%1000000009;
			}
			dp[i][i]=1;
		}
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int m = stoi(st.nextToken());
			long result=0;
			for(int j=1;j<=m;j++) {
				result=(result+dp[num][j])%1000000009;
			}
			sb.append(result+ "\n");
		}
		System.out.println(sb);
	}
	public static int stoi(String str) {return Integer.parseInt(str);}
}