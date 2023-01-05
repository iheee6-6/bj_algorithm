import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0;;i++) {
			if(palind(num+i)&&prime(num+i)) {
				System.out.println(num+i);
				break;
			}
		}
	}
	static boolean prime(int num) {
		if(num==0||num==1) return false;
		else if(num==2) return true;
		for(int i=2;i<num;i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	
	static boolean palind(int num) {
		String str = Integer.toString(num);
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)==str.charAt(str.length()-i-1)) continue;
			else return false;
		}
		return true;
	}
}
