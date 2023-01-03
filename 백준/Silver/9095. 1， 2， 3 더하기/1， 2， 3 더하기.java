import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 int[] dp= new int[11];
		 dp[1]=1;
		 dp[2]=2;
		 dp[3]=4;
		 for(int j=4;j<=10;j++) {
			 dp[j]=dp[j-3]+dp[j-2]+dp[j-1];
		 }
		 for(int i=0;i<n;i++) {
			 int a =Integer.parseInt(br.readLine());
			 System.out.println(dp[a]);
		 }
	}
	
}