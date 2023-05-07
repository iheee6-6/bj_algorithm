import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 에라토스테네스의 체
		boolean[] arr = new boolean[n + 1];
		arr[0] = arr[1] = true;
		for (int j = 2; j * j <= n; j++) {
			if (!arr[j]) {
				for (int i = j*j; i <= n; i+=j) {
					arr[i]=true;
				}
			}
		}

		int result = 0;
		int sum = 0;
		for (int i = 2; i <= n; i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i; j <= n; j++) {
				if (!arr[j]) {
					sum += j;
					if (sum > n) {
						sum = 0;
						break;
					} else if (sum == n) {
						result++;
						sum = 0;
						break;
					}
				}
			}
		}

		System.out.println(result);
	}

}
