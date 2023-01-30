
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long l = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long h = Integer.parseInt(st.nextToken());
		
		double high=Math.max(l, Math.max(w, h));
		double low=0;
		for(int i=0;i<10000;i++) {
			double mid =(high+low)/2;
			if((long)(l/mid)*(long)(w/mid)*(long)(h/mid)<n) {
				high =mid;
			}else {
				low=mid;
			}
		}
		
		System.out.println(low);
	}

}