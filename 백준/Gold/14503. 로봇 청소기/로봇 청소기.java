import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, count = 0;
	static int r, c, d;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken()); // 0:북 , 1:동 , 2:남, 3:서

		visited = new boolean[n][m];
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			clean(r, c);
			switch (findRound(r, c, d)) {
			case 1:
				d = d - 1 < 0 ? 3 : d - 1;
				if (arr[r + dx[d]][c + dy[d]] == 0) {
					r = r + dx[d];
					c = c + dy[d];
				}
				break;
			case 0:
				int behind= d;
				switch(d) {
				case 1: behind=3;break;
				case 2: behind=0;break;
				case 3: behind=1;break;
				case 0: behind=2;break;
				}
				r=r + dx[behind];
				c=c + dy[behind];
				if (arr[r][c] == 1) {
					System.out.println(count);
					return;
				}
				break;

			}

		}

	}

	static void clean(int x, int y) {
		if (arr[x][y] == 0) {
			arr[x][y] = 2;
			count++;
		}

	}

	static int findRound(int x, int y, int dir) {
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || yy < 0 || xx >= n || yy >= m || visited[xx][yy])
				continue;
			if (arr[xx][yy] == 0)
				return 1;
		}
		return 0;
	}

}
