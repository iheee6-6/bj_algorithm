import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main { //시간초과 // ListIterator<String> iter = origin.listIterator(); 쓰기

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split("");
	//	LinkedList<String> list = new LinkedList<>(Arrays.asList(arr));
		LinkedList<String> list = new LinkedList<>();
		for(int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}int m = Integer.parseInt(br.readLine());
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			iter.next();
		}
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("P")) {
				iter.add(input[1]);
			} else if (input[0].equals("L")) {
				if (iter.hasPrevious())
					iter.previous();
			} else if (input[0].equals("D")) {
				if (iter.hasNext())
					iter.next();
			} else if (input[0].equals("B")) {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}
		}

//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i <list.size(); i++)
//			sb.append(list.get(i));
//		System.out.print(sb);

		for(String str : list) {
			bw.write(str);
		}
		
		bw.flush();
		bw.close(); 
	}

}
