import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String p = br.readLine();
		int result=1;
		int idx=0;
		for(int i=0;i<p.length();i++) {
			if(s.indexOf(p.substring(idx,i+1))!=-1) continue;
			result++;
			idx=i;
		}
		
		System.out.println(result);
	}

}
