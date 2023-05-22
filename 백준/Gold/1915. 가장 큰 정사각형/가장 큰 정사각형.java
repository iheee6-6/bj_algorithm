import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int result = 0, n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = str.charAt(j - 1) - '0';
			}
		}

		if (n == 1 && m == 1) {
			System.out.println(arr[1][1]);
			return;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = Math.min(arr[i - 1][j], Math.min(arr[i][j - 1], arr[i - 1][j - 1])) + 1;
					result = Math.max(arr[i][j], result);
				}
			}
		}

		System.out.println(result*result);

	}

}
