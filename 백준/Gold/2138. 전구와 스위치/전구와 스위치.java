import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String[] now ;
	static String[] goal;
	static int n;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		now = br.readLine().split("");
		goal = br.readLine().split("");
		
		String[] nowTemp=now.clone();
		int count1=0;
		for(int i=1;i<n;i++) {
			if(!now[i-1].equals(goal[i-1])) {
				press(i);
				count1++;
			}
			
		}
		if(checkSame()) {
			result=Math.min(result, count1);
		}
		now=nowTemp;
		press(0);
		count1=1;
		for(int i=1;i<n;i++) {
			if(!now[i-1].equals(goal[i-1])) {
				press(i);
				count1++;
			}
		}
		if(checkSame()) {
			result=Math.min(result, count1);
		}
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}
	
	static void press(int i) {
		if(i==0) {
			now[i]=now[i].equals("1")?"0":"1";
			now[i+1]=now[i+1].equals("1")?"0":"1";
		}else if(i==n-1){
			now[i]=now[i].equals("1")?"0":"1";
			now[i-1]=now[i-1].equals("1")?"0":"1";
		}else {
			now[i]=now[i].equals("1")?"0":"1";
			now[i+1]=now[i+1].equals("1")?"0":"1";
			now[i-1]=now[i-1].equals("1")?"0":"1";
		}
	}
	static boolean checkSame() {
		for(int i=0;i<n;i++) {
			if(!now[i].equals(goal[i])) return false;
		}
		return true;
	}
	
	

}
