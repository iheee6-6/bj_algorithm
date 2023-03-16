import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			arr[i]=value;
			sum += value;
		}
		long m = Long.parseLong(br.readLine());

		Arrays.sort(arr);
		long result = m / n-1;
		long max=0;
		if (m >= sum)
			result = arr[n-1];
		else {
			while (max<m) {
				result++;
				long temp=0;
				for(int i=0;i<n;i++) {
					if(result>=arr[i]) {
						temp+=arr[i];
					}else {
						temp+=result;
					}
				}
				max=Math.max(max, temp);
				if(max>m) result--;
			}
			
		}
		System.out.println(result);
	}

}
