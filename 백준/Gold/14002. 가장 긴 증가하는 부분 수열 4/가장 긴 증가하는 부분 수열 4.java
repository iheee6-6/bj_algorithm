import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[num];
		dp[0]=1;
		int max=1;
		for(int i=1;i<num;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					max=Math.max(max, dp[i]);
				}
			}
		}
		
		System.out.println(max);
		Stack<Integer> s = new Stack<>();
		for(int i=num-1;i>=0;i--) {
			if(dp[i]==max) {
				s.add(arr[i]);
				max--;
			}
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}

	}

}
