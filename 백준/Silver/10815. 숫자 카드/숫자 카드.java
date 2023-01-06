import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		long[] arr1 = new long[num];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<num;i++) {
			arr1[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr1);
		//체크할 숫자들
		int checknum = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		for(int j=0;j<checknum;j++) {
			long a=Long.parseLong(st.nextToken());
			int temp=0;
			int mid,low=0,high=num-1;
			while(low<=high) {
				mid= (low+high)/2;
				if(arr1[mid]==a) {temp=1; break;}
				else if(arr1[mid]>a) high=mid-1;
				else low=mid+1;
			}
			System.out.print(temp+" ");
		}
	}
}