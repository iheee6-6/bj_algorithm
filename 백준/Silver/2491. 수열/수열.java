import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int num, max = 1;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		arr = new int[num];
		dp = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int now = 1;
 		for (int i = 0; i < num - 1; i++) {
 			if (arr[i] >= arr[i + 1]) {
    				now++;
  			}
			else now =1;
			if (max < now)
				max = now;
		}
		now=1;
		for (int i = 0; i < num - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				now++;
			}
			else now =1;
			if (max < now)
				max = now;
		}

		System.out.println(max);
	}

}