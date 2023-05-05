import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int k= Integer.parseInt(br.readLine());
		
		find(n,k);
		System.out.println(result);
	}

	static void find(int n,int k) {
		int left=1;
		int end=k;
		while(left<=end) {
			int mid = (left+end)/2;
			
			int count=0;
			for(int i=1;i<n+1;i++) {
				count+=Math.min(mid/i, n);
			}
			
			if(count<k)
				left=mid+1;
			else {
				result=mid;
				end=mid-1;
			}
		}
	}
}
