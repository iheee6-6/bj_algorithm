import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine());
			char[] arr = st.nextToken().toCharArray();
			int sum=0;
			int length=0;
			for(int j=0;j<arr.length;j++) {
				if(arr[j]=='O') {
					length++;
					sum+=length;
				}else {
					length=0;
				}
			}
			System.out.println(sum);
		}
	}

}