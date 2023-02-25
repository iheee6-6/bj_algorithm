
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[] prime = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			prime[i] = i;
		}

		for (int i = 2; i <n; i++) { //에라토스테네스의 체
			if (prime[i] == 0)
				continue;
			for (int j = 2*i; j <= n; j += i)
				prime[j] = 0;
		}

		for (int i = m; i <= n; i++) {
			if (prime[i] != 0) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}

}
