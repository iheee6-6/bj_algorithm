import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		num= new int[cnt];
		dp= new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cnt; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int j=0;j<cnt;j++) {
			for(int z=0;z<j;z++) {
				if(num[j]>num[z]&& dp[j] < dp[z] + 1) dp[j]+=1;
			}
		}

		int max =0;
		for(int y=0;y<cnt;y++) {
			if(max<dp[y]) max=dp[y];
		}
		System.out.println(max+1);
	}
}