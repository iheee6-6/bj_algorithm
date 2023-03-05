import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] arra= new int[a];
			int[] arrb= new int[b];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<a;j++) {
				arra[j]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<b;j++) {
				arrb[j]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arra);
			Arrays.sort(arrb);
			int count=0;
			for(int j=0;j<a;j++) {
				for(int z=0;z<b;z++) {
					if(arra[j]>arrb[z]) count++;
					else break;
				}
			}
			System.out.println(count);
		}
		
	}

}
