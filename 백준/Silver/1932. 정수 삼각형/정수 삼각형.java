import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static int[][] arr;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num =Integer.parseInt(br.readLine());
		dp= new int[num][num];
		arr= new int[num][num];
		StringTokenizer st;
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < num; i++) {
			dp[num - 1][i] = arr[num - 1][i];
		}
		find(0,0);
		System.out.println(dp[0][0]);
	}

	static int find(int depth,int side) {
		if(depth==num-1) return dp[depth][side];
		if(dp[depth][side]==0) {
			dp[depth][side]=Math.max(find(depth+1,side),find(depth+1,side+1))+arr[depth][side];
		}
		return dp[depth][side];
	}
}