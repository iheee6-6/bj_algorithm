import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, result = 0;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count=0;
		while ((count=check())<2) {
			if (count==0) {
				result=0;
				break;
			}

			result++;

			arr=live();

		}
		
		System.out.println(result);
	}

	static int check() {
		visited= new boolean[n][m];
		int countTemp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > 0&&visited[i][j]==false) {
					dfs(i,j);
					countTemp++;
				}
			}
		}

		return countTemp ;
	}

	static void dfs(int x,int y) {
		visited[x][y]=true;
		for (int z = 0; z < 4; z++) {
			int xx = x + dx[z];
			int yy = y + dy[z];
			if (xx < 0 || yy < 0 || xx > n - 1 || yy > m - 1||visited[xx][yy])
				continue;
			if (arr[xx][yy] > 0) {
				dfs(xx,yy);
			}
		}
	}
	static int[][] live() {
		int[][] arr2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int minus=0;
				if (arr[i][j] > 0) {
					for (int z = 0; z < 4; z++) {
						int xx = i + dx[z];
						int yy = j + dy[z];
						if (xx < 0 || yy < 0 || xx > n - 1 || yy > m - 1)
							continue;
						if (arr[xx][yy] == 0) {
							minus++;
						}
					}
				}
				arr2[i][j]=arr[i][j]-minus<=0?0:arr[i][j]-minus;
			}
		}
		
		return arr2;
	}
}
