import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,count=0;
	static int sum;
	static int[] arr ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int re = sum;
		for(int i=n-1;i>-1;i--) {
			if(arr[i]<=re) {
				count+=re/arr[i];
				re = re%arr[i];
			}
		}
		System.out.println(count);
	}
}