import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		long[] arr = new long[cnt];
		for(int i=0;i<cnt;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]==0) {
				for(int j=i-1;j>=0;j--) {
					if(arr[j]!=0) {
						arr[j]=0;
						break;
					}
				}
			}
		}
		int result=0;
		for(int z=0;z<cnt;z++) {
			result+=arr[z];
		}
		System.out.println(result);
	}
}