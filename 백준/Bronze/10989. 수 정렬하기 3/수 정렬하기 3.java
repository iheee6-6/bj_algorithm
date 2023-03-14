import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr =new int[n];
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
