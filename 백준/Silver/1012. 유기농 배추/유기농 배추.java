import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[][] check;
	static int M, N;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int k = 0; k < num; k++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			check = new boolean[M][N];
			for (int i = 0; i < cc; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[j][i] == 1 && !check[j][i]) {
						result++;
						dfs(j,i);
					}
				}
			}
			System.out.println(result);
		}
	}
	
	static void dfs(int x,int y) {
		check[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(nx>=0&&ny>=0&&nx<M&&ny<N) {
				if(arr[nx][ny]==1&&!check[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
	}

}