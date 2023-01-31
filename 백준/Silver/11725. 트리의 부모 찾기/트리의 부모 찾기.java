import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] arr;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new ArrayList[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i]= new ArrayList<Integer>();
		}
		parents = new int[n + 1];
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x].add(y);
			arr[y].add(x);
		}
		dfs(1,0);
		for (int i = 2; i < n + 1; i++)
			System.out.println(parents[i]);
	}

	static void dfs(int start, int parent) {
		parents[start]=parent;
		for(int item : arr[start]) {
			if(item!=parent) dfs(item,start);
		}
	}

}