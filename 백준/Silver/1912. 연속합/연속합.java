import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static Integer[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[cnt+1];
		dp = new Integer[cnt+1];
		for(int i=1;i<cnt+1;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		dp[0]=arr[0];
		dp[1]=arr[1];
		if(cnt>1) {
			dp[2]=Math.max(arr[2],arr[1]+arr[2]);
		}
		fc(cnt);
		int max=dp[1];
		for(int j=2;j<dp.length;j++) {
			if(max<dp[j]) max=dp[j];
		}
		System.out.println(max);
	}
	
	static int fc(int n) {
		if(dp[n]==null) {
			dp[n]=Math.max(arr[n], fc(n-1)+arr[n]);
		}
		return dp[n];
	}
}
