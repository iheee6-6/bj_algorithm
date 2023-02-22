import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static class Word{
		String str;
		int count;
		Word(String str,int count){
			this.str=str;
			this.count=count;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		ArrayList<Word> arrlist = new ArrayList<>();
		for(String str:map.keySet()) {
			arrlist.add(new Word(str,map.get(str)));
		}
		Collections.sort(arrlist,(w1,w2)->{
			if(w1.count==w2.count) {
				return w2.str.compareTo(w1.str);
			}
			return w2.count-w1.count;
		});
		
		System.out.println(arrlist.get(0).str+" "+arrlist.get(0).count);
	}

}