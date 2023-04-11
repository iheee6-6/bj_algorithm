import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			if (x == 1) {
				for(int j=1;j<n+1;j++) {
					if(j%idx==0)
						arr[j] = arr[j] == 1 ? 0 : 1;
				}
			} else {
				arr[idx] = arr[idx] == 1 ? 0 : 1;
				int j = 1;
				while (true) {
					if (idx - j <= 0 || idx + j > n)
						break;
					if (arr[idx + j] == arr[idx - j]) {
						arr[idx + j] = arr[idx + j] == 1 ? 0 : 1;
						arr[idx - j] = arr[idx - j] == 1 ? 0 : 1;
						j++;
					} else
						break;
				}
			}
		}

		for (int j = 1; j < n + 1; j++) {
			System.out.print(arr[j]);
			if (j % 20 == 0) {
				System.out.println();
			}else {
				System.out.print(" ");
			}
		}

	}

}
