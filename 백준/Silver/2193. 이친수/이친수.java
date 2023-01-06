import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
	    long[] dp = new long[num+1];
		dp[1]=1;
		dp[0]=0;
		if(num>1) 
			dp[2]=1;
		for(int i=3;i<num+1;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[num]);
	}
}
