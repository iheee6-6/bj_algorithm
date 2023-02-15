import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n= Integer.parseInt(br.readLine());
		back("1");
		
	}
	static void back(String str) {
		if(str.length()==n) {
			System.out.println(str);
			System.exit(0);
		}
		for(int i=1;i<=3;i++) {
			if(find(str+i)) {
				back(str+i);
			}
		}
	}
	static boolean find(String str) {
		for(int j=1;j<=str.length()/2;j++) {
			for(int k=0;k<=str.length()-2*j;k++) {
				if(str.substring(k, k+j).equals(str.substring(k+j,k+j+j))) {
					return false;
				}
			}
		}
		return true;
	}

}