import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Long[][] dp= new Long[100001][4];
		for(int i=1;i<100001;i++) {
			dp[i][1]=(long)0;
			dp[i][2]=(long)0;
			dp[i][3]=(long)0;
		}
		dp[1][1]=(long)1;//1
		dp[2][1]=(long)0;
		dp[2][2]=(long)1;//2
		dp[3][1]=(long)1; //2+1
		dp[3][2]=(long)1;//1+2
		dp[3][3]=(long)1;//3
		StringBuilder sb = new StringBuilder();
		for(int i=4;i<100001;i++) {
			dp[i][1]=(dp[i-1][2]+dp[i-1][3])%1000000009;
			dp[i][2]=(dp[i-2][1]+dp[i-2][3])%1000000009;
			dp[i][3]=(dp[i-3][1]+dp[i-3][2])%1000000009;
		}
		for(int i=0;i<num;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1]+dp[n][2]+dp[n][3])%1000000009+"\n");
		}
		System.out.println(sb);
	}

}
