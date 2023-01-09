import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			String str = br.readLine();
			int open=0;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') {
					open++;
				}else open--;
				if(open==-1) break;
			}
			if(open==0)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}
}
