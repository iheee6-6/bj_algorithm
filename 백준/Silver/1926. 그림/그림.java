import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a, b,w;
	static int[][] arr;
	static boolean[][] checked;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static long count=0;
	static long max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[a][b];
		checked = new boolean[a][b];
		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < b; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if (arr[i][j] == 1 && !checked[i][j]) {
					w=0;
					find(i,j);
					count++;
					max=max<w?w:max;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	static void find(int x, int y) {
		if (x < a && y < b&&x > -1 && y > -1) {
			if (arr[x][y] == 1 && !checked[x][y]) {
				w++;
				checked[x][y] = true;
				for (int i = 0; i < 4; i++) {
					int xx = x + dx[i];
					int yy = y + dy[i];
					find(xx, yy);
				}
			}
		}
	}

}
