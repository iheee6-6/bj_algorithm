import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result =n;
		for(int i=0;i<n;i++) {
			String str =br.readLine();
			char[] sc = str.toCharArray();
			boolean check =true;
			for(int j=0;j<sc.length-1;j++) {
				for(int z=j+1;z<sc.length;z++) {
					if(sc[j]==sc[z]) {
						if(z-1!=j) {
							if(sc[z-1]==sc[z]) continue;
							check=false;
							result--;
							break;
						}
					}
				}
				if(!check) break;
			}
		}
		System.out.println(result);
	}
}