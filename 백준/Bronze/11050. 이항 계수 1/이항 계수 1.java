import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		if(k<0||k>n) System.out.println(0);
		else {
			int ntemp=1;
			int ktemp=1;
			int nktemp=1;
			for(int i=1;i<=n;i++) {
				ntemp*=i;
			}
			for(int i=1;i<=k;i++) {
				ktemp*=i;
			}
			for(int i=1;i<=n-k;i++) {
				nktemp*=i;
			}
			System.out.println(ntemp/(ktemp*nktemp));
		}
	}

}