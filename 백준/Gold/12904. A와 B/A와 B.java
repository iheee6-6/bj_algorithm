import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		
		while (s.length() < t.length()) {
			StringBuffer sb = new StringBuffer();
			if (t.endsWith("A")) {
				t = t.substring(0, t.length() - 1);
			} else if (t.endsWith("B")) {
				t = t.substring(0, t.length() - 1);
				t = sb.append(t).reverse().toString();
			}
		}

		if (s.equals(t)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}