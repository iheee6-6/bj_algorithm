import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int MOD=1000000003;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K= Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][N+1]; //N자리까지 N개 뽑는 경우의 수
		for(int i=0;i<=N;i++) {
			dp[i][1]=i; //1개 뽑는 경우의 수		
		}
		
		for(int i=4;i<=N;i++) {
			for(int j=2;j<=K;j++) { //[i][1]까지는 이미 위에서 세팅했기 때문에 2부터 시작,
				dp[i][j]=(dp[i-1][j]+dp[i-2][j-1])%MOD;
			}
		}
		
		System.out.println(dp[N][K]%MOD); 
	}

}
