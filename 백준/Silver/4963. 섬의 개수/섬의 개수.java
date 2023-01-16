import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr, dp;
	static boolean[][] check;
	static int w, h;
	static int[] dx = { 0, 0, -1, 1, -1, 1, 1, -1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			arr = new int[h][w];
			dp = new int[h][w];
			check = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !check[i][j]) {
								find(i, j);
								result++;
                    }
				}
			}
			System.out.println(result);
		}
	}

	static void find(int x, int y) {
		check[x][y] = true;
		if (x == w && y == h)
			return;
		for (int i = 0; i < 8; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && xx < h && yy < w && yy >= 0) {
				if (arr[xx][yy] == 1 && !check[xx][yy]) {
					find(xx, yy);
				}
			}
		}
	}

}