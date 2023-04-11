import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			list[i]= new ArrayList<>();
		}
		parent= new int[n+1];
        
		for(int i=0;i<n+1;i++)
			parent[i]=i;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(x==0) {
				unionParent(a,b);
			}else {
				if(isSameParent(a,b)) {
					System.out.println("YES");
				}else 
					System.out.println("NO");
			}
		}
		
		
	}

	static int[] parent;
	static boolean isSameParent(int x, int y) {
		x= find(x);
		y=find(y);
		if(x==y) {
			return true;
		}
		return false;
	}
	static void unionParent(int a, int b) {
		a= find(a);
		b= find(b);
		if(a!=b) {
			if(a<b) parent[b]=a;
			else parent[a]=b;
		}
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x]=find(parent[x]);
	}
}
