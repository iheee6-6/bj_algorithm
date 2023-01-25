import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 어렵 백트래킹..
	static int n, s, sum, count;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		if (s == 0)
			System.out.println(count - 1);
		else
			System.out.println(count);
	}

	public static void dfs(int depth, int sum) {
		if (depth == n) {
			if (s == sum) {
				count++;
			}
			return;
		}
		dfs(depth + 1, sum + arr[depth]);
		dfs(depth + 1, sum);
	}

}