import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[] dp1;
	static Integer[] dp2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		dp1= new Integer[cnt+1];
		dp2= new Integer[cnt+1];
		dp1[0]=1;
		dp1[1]=0;
		dp2[0]=0;
		dp2[1]=1;
		if(cnt>1) {
			dp1[2]=1;
			dp1[3]=1;
			fc(cnt,dp1);
			dp2[2]=1;
			dp2[3]=2;
			fc(cnt,dp2);
		}
		System.out.println(dp1[cnt]+" "+dp2[cnt]);
	}
	static Integer fc(int n,Integer[] arr) {
		if(arr[n]==null) {
			arr[n]=fc(n-1,arr)+fc(n-2,arr);
		}
		return arr[n];
	}
}