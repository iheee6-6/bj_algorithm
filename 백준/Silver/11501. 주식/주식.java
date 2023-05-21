import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int d = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[d];
			for(int j=0;j<d;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			
			long result=0;
			long max =0;
			for(int j=d-1;j>=0;j--) {
				if(max<arr[j]) {
					max=arr[j];
				}else {
					result+=max-arr[j];
				}
			}
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}

}
