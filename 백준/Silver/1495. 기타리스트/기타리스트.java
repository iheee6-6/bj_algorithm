import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] v, dp;
	static int n,s,m;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //개수
		s = Integer.parseInt(st.nextToken()); //시작
		m = Integer.parseInt(st.nextToken()); //최고 볼륨
		v= new int[n+1];
		dp= new int[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			v[i] = Integer.parseInt(st.nextToken());
			if(i==1) {
				if(s+v[i]<=m)
					dp[s+v[i]]=i;
				if(s-v[i]>=0)
					dp[s-v[i]]=i;
			}else {
				ArrayList<Integer> arrlist = new ArrayList<>();
				for(int j=0;j<=m;j++) {
					if(dp[j]==i-1) {
						if(j+v[i]<=m)
							arrlist.add(j+v[i]);
						if(j-v[i]>=0)
							arrlist.add(j-v[i]);
					}
				}
				for(int j=0;j<arrlist.size();j++) {
					dp[arrlist.get(j)]=i;
				}
			}
			
		}
		for(int i=0;i<=m;i++) {
			if(dp[i]==n) {
				max=Math.max(max, i);
			}
		}
		System.out.println(max==Integer.MIN_VALUE?-1:max);
	}

	
}
