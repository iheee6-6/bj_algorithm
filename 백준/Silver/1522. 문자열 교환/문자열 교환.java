import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int aCount=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='a') aCount++;
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			int bCount=0;
			for(int j=0;j<aCount;j++) {
				int idx=(i+j)%arr.length;
				if(arr[idx]=='b') bCount++; 
			}
			min=Math.min(min, bCount);
		}
		
		System.out.println(min==Integer.MAX_VALUE?0:min);
	}

}
