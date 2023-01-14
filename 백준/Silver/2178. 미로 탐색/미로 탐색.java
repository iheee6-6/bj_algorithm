import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class spot {
	int x;
	int y;

	spot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N,M;
	static int[][] arr;
	static boolean[][] check;
	static int[][] dp;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<spot> q = new LinkedList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.split("")[j]);
			}
		}

		bfs(0, 0);
		System.out.println(dp[N-1][M-1]+1);
	}

	static void bfs(int x, int y) {
		q.add(new spot(x, y));
		while (!q.isEmpty()) {
			spot s = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextx = s.x + dx[i];
				int nexty = s.y + dy[i];
				if (nextx >= 0 && nexty >= 0 && nextx < N && nexty < M) {
					if (arr[nextx][nexty] == 1 && !check[nextx][nexty]) {
						q.add(new spot(nextx, nexty));
						dp[nextx][nexty]=dp[s.x][s.y] + 1;
						check[nextx][nexty] = true;
					}
				}
			}
		}

	}
}