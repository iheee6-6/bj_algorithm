import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			String[] str = new String[n];
			String result="YES";
			for(int j=0;j<n;j++) {
				str[j]=br.readLine();
			}
			Arrays.sort(str);
			
			for(int z=0;z<n-1;z++) {
                if(str[z].length()>str[z+1].length()) continue;
				if(str[z+1].startsWith(str[z])) {
					result="NO";
					break;
				}
			}
			System.out.println(result);
			
		}
	}

}
