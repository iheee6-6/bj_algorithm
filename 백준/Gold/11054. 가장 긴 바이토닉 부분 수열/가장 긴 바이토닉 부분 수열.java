import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr, up, down;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		down = new int[n];
		up = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		// 상승
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, up[j]);
				}
			}
			up[i] = max + 1;
		}

		// 하강
		for (int i = n - 1; i >= 0; i--) {
			int max = 0;
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, down[j]);
				}
			}
			down[i] = max + 1;
		}

		for (int i = 0; i < n; i++) {
			result = Math.max(result, up[i] + down[i]);
		}

		System.out.println(result - 1);

		// 이건 연속인 바이토닉 수열..
		/*
		 * for (int j = 1; j < n; j++) { boolean up = true; int count=1; for (int i = j;
		 * i < n; i++) { if (arr[i] > arr[i - 1]) { if (up) count++; else break; } else
		 * if (arr[i] < arr[i - 1]) { up = false; count++; } else { break; } }
		 * dp[j]=count; } Arrays.sort(dp); System.out.println(dp[n - 1]);
		 */
	}

}