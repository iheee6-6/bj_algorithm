import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		long result=0;
		for(int i=1;i<n+1;i++) {
			result+=Math.abs(arr[i-1]-i);
		}
		System.out.println(result);
	}

}
