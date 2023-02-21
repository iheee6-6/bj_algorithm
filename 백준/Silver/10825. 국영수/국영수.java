import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static class Student {
		String name;
		int a; //국
		int b; //영
		int c; //수
		Student(String name,int a,int b, int c){
			this.a=a;
			this.b=b;
			this.c=c;
			this.name=name;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Student[] arr = new Student[n];
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			arr[i]=new Student(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3]));
		}
		Arrays.sort(arr,(s1,s2)->{
			if(s1.a==s2.a) {
				if(s1.b==s2.b) {
					if(s1.c==s2.c) {
						return s1.name.compareTo(s2.name);
					}else {
						return s2.c-s1.c;
					}
				}else {
					return s1.b-s2.b;
				}
			}else {
				return s2.a-s1.a;
			}
		});
		for(int i=0;i<n;i++) {
			System.out.println(arr[i].name);
		}
		
	}

}