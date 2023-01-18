import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp= new int[1000];;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(find(num));
	}
	static int find(int num) {
		int count=0;
		if(num<100) {
			return num;
		}else {
			count+=99;
			for(int i=100;i<=num;i++) {
				int a = i/100;
				int b = (i/10)%10;
				int c=i%10;
				if((b-a)==(c-b)) {
					count++;
				}
			}
		}
		return count;
	}

}