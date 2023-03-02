import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int result=0;
			ArrayList<Integer> arr = new ArrayList<>();
			int idx=0;
			st = new StringTokenizer(br.readLine());
			int caseNum=Integer.parseInt(st.nextToken());
			while(idx<=19) {
				int num= Integer.parseInt(st.nextToken());
				arr.add(num);
				for(int j=idx-1;j>=0;j--) {
					if(arr.get(j)>arr.get(j+1)) {
						arr.set(j+1, arr.get(j));
						arr.set(j, num);
						result++;
					}else break;
				}
				++idx;
			}
			sb.append(caseNum+" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

}
