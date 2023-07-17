import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int choco =1;
		while(n>choco) {
			choco*=2;
		}
		
		StringBuilder sb= new StringBuilder();
		sb.append(choco).append(" ");
		
		int cut=0;
		while(true) {
			if(n%choco==0) {
				sb.append(cut);
				break;
			}
			choco/=2;
			cut++;
		}
		
		System.out.println(sb.toString());
	}

}
