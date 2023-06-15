import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int s= Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<s;i++) {
			int idx=Integer.parseInt(st.nextToken());
			arr[idx]--;
		}


		st = new StringTokenizer(br.readLine());
		for(int i=0;i<r;i++) {
			int idx=Integer.parseInt(st.nextToken());
			arr[idx]++;
		}
		
		for(int i=1;i<=n;i++) {
			if(arr[i]==1) {
				if(i-1>0&&arr[i-1]==-1) {
					arr[i]=0;
					arr[i-1]=0;
				}else if(i+1<=n&&arr[i+1]==-1) {
					arr[i]=0;
					arr[i+1]=0;
				}
			}
		}
		
		
		int result=0;
		for(int i=1;i<=n;i++) {
			if(arr[i]==-1) result++; 
		}
		System.out.println(result);
		
	}

}
