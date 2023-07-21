import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] line = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 0;

		int result = 0;
		int[] map = new int[100001];
		while (right < n) {
			if (map[line[right]] >= k) {
				map[line[left]]--;
				left++;
			} else {
				map[line[right]]++;
				right++;
			}
			result = Math.max(result, right - left);
		}

		System.out.println(result);
	}

}
