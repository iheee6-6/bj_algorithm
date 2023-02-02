import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr, m = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			m[i] = Integer.parseInt(st.nextToken());// 0+,1-,2*,3/

		find(0, m[0], m[1], m[2], m[3], arr[0]);
		System.out.println(max + "\n" + min);

	}

	static void find(int idx, int p, int m, int mul, int mod, long result) {
		if (idx == n - 1) {
			min = min < result ? min : result;
			max = max < result ? result : max;
			return;
		}
		if (p > 0) {
			find(idx+1, p - 1, m, mul, mod, result + arr[idx + 1]);
		}
		if (m > 0) {
			find(idx+1, p, m - 1, mul, mod, result - arr[idx + 1]);
		}
		if (mul > 0) {
			find(idx+1, p, m, mul - 1, mod, result * arr[idx + 1]);
		}
		if (mod > 0) {
			find(idx+1, p, m, mul, mod - 1, result / arr[idx + 1]);
		}

	}
}