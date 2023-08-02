import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		int result=0;
		boolean lonelyRed =false;
		//왼쪽으로 빨 모으기
		for(int i=0;i<n;i++) {
			if(lonelyRed&&arr[i]=='R') {
				result++;
			}
			if(arr[i]=='B') {
				lonelyRed=true;
			}
		}
		

		int tempResult=0;
		boolean lonelyBlue =false;
		//왼쪽으로 파 모으기
		for(int i=0;i<n;i++) {
			if(lonelyBlue&&arr[i]=='B')
				tempResult++;
			if(arr[i]=='R') lonelyBlue=true;
		}
		
		result= Math.min(result, tempResult);
		
		tempResult=0;
		lonelyRed =false;
		//오른쪽으로 파 모으기
		for(int i=n-1;i>=0;i--) {
			if(lonelyRed&&arr[i]=='R')
				tempResult++;
			if(arr[i]=='B') lonelyRed=true;
		}
		result= Math.min(result, tempResult);
		
		tempResult=0;
		lonelyBlue =false;
		//오른쪽으로 파 모으기
		for(int i=n-1;i>=0;i--) {
			if(lonelyBlue&&arr[i]=='B')
				tempResult++;
			if(arr[i]=='R') lonelyBlue=true;
		}
		result=Math.min(result, tempResult);
		
		System.out.println(result);
		
	}

}
