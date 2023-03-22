import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance=new long[n-1];
		for(int i=0;i<n-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long[] cost=new long[n];
		long min =Integer.MAX_VALUE;
		int minIdx=0;
		for(int i=0;i<n;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
			if(i<n-1) {
				if(min>cost[i]){
					minIdx=i;
					min=cost[i];
				}
			}
		}
		
		long result=0;
		for(int i=0;i<n-1;i++) {
			if(minIdx>i) {
				result+=cost[i]*distance[i];
			}else {
				result+=min*distance[i];
			}
		}
		
		System.out.println(result);
		
	}

}
