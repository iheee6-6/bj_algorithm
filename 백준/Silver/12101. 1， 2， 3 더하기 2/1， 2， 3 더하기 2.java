import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<String>[] arr = new ArrayList[num+3];
		for(int i=0;i<=num+2;i++) {
			arr[i]=new ArrayList<>();
		}
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+1+1");
		arr[3].add("1+2");
		arr[3].add("2+1");
		arr[3].add("3");
		
		for(int i=4;i<=num;i++) {
			for(int j=1;j<=3;j++) {
				for(String str :arr[i-j])
				arr[i].add(str+"+"+j);
			}
		}
		
		if(arr[num].size()<k) {
			System.out.println(-1);
		}else {
			Collections.sort(arr[num]);
			System.out.println(arr[num].get(k-1));
		}
	}

}