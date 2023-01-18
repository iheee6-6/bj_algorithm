import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result=0;
		for(int i=0;i<num;i++) {
			result+=arr[i];
			for(int j=0;j<i;j++) {
				result+=arr[j];
			}
		}
		System.out.println(result);
	}
}