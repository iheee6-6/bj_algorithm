import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] dp = new int[41];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		int result=1;
		int prev=0;
		for (int i = 0; i < m; i++) {
			int idx = Integer.parseInt(br.readLine());
			result*=dp[idx-prev-1];
			prev=idx;
		}
		result*=dp[n-prev];
		
		
		System.out.println(result);
	}

}
