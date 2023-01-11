import java.io.*;
import java.util.*;
// dfs + dp 문제 
public class Main{
	static int N, M;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine() , " ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// -1 로 초기화 , 방문할시 0처리 
				dp[i][j] = -1;
			}
		}
		
		System.out.println(searchDown(0,0));
	}
	private static int searchDown(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		// dfs 방식이므로 dp가 -1 아니라면 이미 탐색한 경로이므로 return dp;
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 > nx || nx >= N || 0>ny || ny>= M || map[x][y] <= map[nx][ny]) continue;
			// 가능한 경로를 dp += 1
			dp[x][y] += searchDown(nx, ny);
		}
		return dp[x][y];
	}
}