import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		// 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					arr[i][j] = 0;
				else
					arr[i][j] = 5001;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		floyd();
		
		int mincount = Integer.MAX_VALUE;
		int min = 0;
		
		for (int i = 1; i <= n; i++) {
			int count = 0;
			for (int j = 1; j <= n; j++) {
				count += arr[i][j];
			}
			if (mincount > count) {
				min = i;
				mincount=count;
			} else if (mincount == count) {
				min = Math.min(i, min);
			}
		}
		System.out.println(min);
	}

	private static void floyd() {
		for (int k = 1; k <= n; k++) { // 거쳐가는 중간 지점 노드
			for (int i = 1; i <= n; i++) { // 시작 노드
				for (int j = 1; j <= n; j++) { // 도착 노드
					arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]); // 최단경로 초기화
				}
			}
		}
	}
}