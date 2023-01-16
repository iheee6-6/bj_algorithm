import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int max = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i]==1 ?1:-1;
			if(sum<0) sum=0;
			if(max<sum) max=sum;
		}
		
		sum=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i]==1 ?-1:1;
			if(sum<0) sum=0;
			if(max<sum) max=sum;
		}
		
		System.out.println(max);
	}
}