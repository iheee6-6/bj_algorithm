import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Dot {
		int x, y;

		Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] arr = new int[a][b];
		boolean[][] checked = new boolean[a][b];
		dp = new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Dot> q = new LinkedList<>();
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					dp[i][j] = 0;
					q.add(new Dot(i, j));
					checked[i][j]=true;
				}
			}
		}

		while (!q.isEmpty()) {
			Dot d=q.poll();
			int x= d.x;
			int y=d.y;
			for(int i=0;i<4;i++) {
				int xx= x+dx[i];
				int yy= y+dy[i];
				if(xx<0||yy<0||xx>=a||yy>=b||checked[xx][yy]) continue;
				if(arr[xx][yy]==1){
					checked[xx][yy]=true;
					dp[xx][yy]=Math.min(dp[x][y]+1,dp[xx][yy]);
					q.add(new Dot(xx,yy));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if(arr[i][j]==0) sb.append(0).append(" ");
				else if(dp[i][j]==Integer.MAX_VALUE) {
					sb.append(-1).append(" ");
				}else 
					sb.append(dp[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
