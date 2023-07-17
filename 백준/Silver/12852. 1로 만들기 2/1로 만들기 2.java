import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int n;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp=new int[n+1];
		dp[1]=0;
		
		int before[] = new int[n+1];
		before[1]=0;
		
		for(int i=2;i<=n;i++) {
			int type=1;
			dp[i]=dp[i-1]+1;
			before[i]=i-1;
			if(i%2==0) {
				if(dp[i/2]+1<dp[i]) {
					dp[i]=dp[i/2]+1;
					type=2;
					before[i]=i/2;
				}
			}
			
			if(i%3==0) {
				if(dp[i/3]+1<dp[i]) {
					dp[i]=dp[i/3]+1;
					type=3;
					before[i]=i/3;
				}
			}
			
		}
		
		
		System.out.println(dp[n]);
		StringBuilder sb = new StringBuilder();
		sb.append(n).append(" ");
		int i=n;
		while(i>1) {
			sb.append(before[i]).append(" ");
			i=before[i];
		}
		System.out.println(sb.toString());
		
	}

}
