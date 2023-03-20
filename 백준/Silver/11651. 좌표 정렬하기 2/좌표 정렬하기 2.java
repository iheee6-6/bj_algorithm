import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static class Dot{
		int x;
		int y;
		Dot(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		ArrayList<Dot> list = new ArrayList<>();
		StringTokenizer st ;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			list.add(new Dot(x,y));
		}
		Collections.sort(list,(d1,d2)->(d1.y==d2.y?d1.x-d2.x:d1.y-d2.y));
		
		StringBuilder sb = new StringBuilder();
		for(Dot dot:list) {
			sb.append(dot.x).append(" "+dot.y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
