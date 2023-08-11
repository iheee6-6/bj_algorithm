import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] buildings= new int[n];
		StringTokenizer  st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			buildings[i]=Integer.parseInt(st.nextToken());
		}
		
		int maxCnt=0;
		for(int i=0;i<n;i++) {
			int cnt=0;
			double temp=0;
			for(int j=i-1;j>=0;j--) { //왼쪽방향
				double tt=(double)(buildings[i]-buildings[j])/(i-j);
				if(temp>tt||j==i-1) {
					temp=tt;
					cnt++;
				}
			}
			
			for(int j=i+1;j<=n-1;j++) {
				double tt=(double)(buildings[j]-buildings[i])/(j-i);
				if(temp<tt||j==i+1) {
					temp=tt;
					cnt++;
				}
			}
			
			maxCnt=Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}

}
