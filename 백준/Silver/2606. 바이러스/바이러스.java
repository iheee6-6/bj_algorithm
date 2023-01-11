import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int N ;
	static int result;
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M =Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr=new int[N+1][N+1];
		check=new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(1);
		System.out.println(result-1);
	}
	static void dfs(int start) {
		check[start]=true;
		result++;
		for(int i=1;i<N+1;i++) {
			if(arr[start][i]==1&&!check[i]) {
				dfs(i);
			}
		}
	}
}