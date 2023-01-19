import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int per = Integer.parseInt(br.readLine());
		int[][] arr = new int[per][2];
		StringTokenizer st;
		for (int i = 0; i < per; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<per;i++) {
			int count=1;
			for(int j=0;j<per;j++) {
				if(i==j) continue;
				if(arr[i][0]<arr[j][0] &&arr[i][1]<arr[j][1]) {
					count++;
				}
			}
			sb.append(count+" ");
			
		}
		System.out.println(sb);
	}

}