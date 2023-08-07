import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int[][] map;

	static boolean[] visited;
	static int[][] dist;
	static int result=Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dist = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = 0; z < n; z++) {
					map[j][z] = Math.min(map[j][i] + map[i][z], map[j][z]);
				}
			}
		}

		visited = new boolean[n];
		visited[k] = true;
		dfs(k, 0,0);
		System.out.println(result);
	}

	static void dfs(int idx, int sum,int depth) {
		if(depth==n-1) {
			result=Math.min(result, sum);
			return;
		}

		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i,sum+map[idx][i],depth+1);
				visited[i]=false;
			}
		}
	}
}
