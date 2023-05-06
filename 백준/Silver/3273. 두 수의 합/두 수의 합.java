import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int number = Integer.parseInt(br.readLine());
		int result = 0;
		int start =0;
		int end=n-1;
		while(start<end) {
			if(arr[start]+arr[end]==number) {
				result++;
				start++;
			}else if(arr[start]+arr[end]<number) {
				start++;
			}else {
				end--;
			}
		}
		System.out.println(result);

	}

}
