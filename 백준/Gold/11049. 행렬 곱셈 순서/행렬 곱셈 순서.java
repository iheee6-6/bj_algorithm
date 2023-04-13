import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[t][2];
		dp=new int[t][t];
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[i][0]=x;
			arr[i][1]=y;
		}
		
		//순서대로 곱하였을 경우
		for(int i=0;i<t-1;i++) {
			dp[i][i+1]=arr[i][0]*arr[i][1]*arr[i+1][1];
		}
		
		for(int n=2;n<t;n++) {
			for(int i=0;i<t-n;i++) {
				int j = n+i;
				dp[i][j]=Integer.MAX_VALUE;
				
				for(int k=i;k<j;k++) {
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+(arr[i][0]*arr[k][1]*arr[j][1]));
				}
			}
		}
		
		System.out.println(dp[0][t-1]);
		
	}

}
