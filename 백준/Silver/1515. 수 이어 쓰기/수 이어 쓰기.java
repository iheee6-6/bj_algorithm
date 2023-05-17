import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int i=0;
		while(true) {
			i++;
			String num=Integer.toString(i);
			while(num.length()>0&&n.length()>0) {
				if(num.charAt(0)==n.charAt(0)) {
					n=n.substring(1);
				}
				num=num.substring(1);
			}
			if(n=="") {
				System.out.println(i);
				break;
			}
			
		}
		

	}

}
