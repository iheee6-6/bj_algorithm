import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		Map<Integer,Integer> map2 = new HashMap<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.put(start, map.get(start)!=null? map.get(start)+1:1);
			map.put(end, map.get(end)!=null? map.get(end)-1:-1);
		}
		
		ArrayList<Integer> arrlist =new ArrayList<>(map.keySet());
		Collections.sort(arrlist);
		
		int count=0;
		int maxCount=0;
		int maxstart=0;
		int maxend=0;
		int maxstartidx=0;
		for(int i=0;i<arrlist.size();i++) {
			int temp =count+map.get(arrlist.get(i));
			count=temp;
			map2.put(arrlist.get(i), temp);
			if(maxCount<temp) {
				maxCount=temp;
				maxstart=arrlist.get(i);
				maxstartidx=i;
			}
		}
		
		while(true) {
			if(map2.get(arrlist.get(++maxstartidx))!=maxCount)
			{
				maxend=	arrlist.get(maxstartidx);
				break;
			}
		}
		System.out.println(maxCount);
		System.out.println(maxstart+" "+maxend);
	}

}