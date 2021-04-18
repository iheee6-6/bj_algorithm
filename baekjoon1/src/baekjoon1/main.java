//package baekjoon1;
//import java.util.Scanner;
package baekjoon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNum = br.readLine();

		 HashMap<Integer,Integer> map = new HashMap<>();
		 for(int i =1;i<Integer.parseInt(inputNum)+1;i++) {
			String input = br.readLine();
			String[] str = input.split(" ");
			HashSet<Integer> line = new HashSet<>();
			Integer result=Integer.parseInt(str[0]);
			for(int j=1;j<str.length;j++) {
				line.add(Integer.parseInt(str[j]));
			}
			for(Integer idx :line) {
				result+=map.get(idx);
			}
			map.put(i,result);
		 }
		 
		 
		 for(Integer m : map.keySet()) {
				System.out.println(map.get(m));
		 }
		 
		//test1_str str = new test1_str();
		//for(int i=0;i<input.length();i++)
			//map.put(i, input.substring(i,i+1));
		//String x=input.substring(0,1);
		//String d=input.substring(1,2);
		//int result = str.solution(map,input);
		//System.out.println(result);
	}
}
//	public static void main(String[] args) throws Exception {
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int idx=1;
//		
//		int mh =0;
//		int h=0;
//		int mid=0;
//		int f=0;
//		int w=0;
//		int r=0;
//		
//		String input = br.readLine();
//		int max = 220 -Integer.parseInt(input);
//
//		ArrayList<String> tmp=new ArrayList<>();
//		//while(true) {
//			try{
//				input = br.readLine();
//				//if(input.equals("")) break;
//			  tmp.add(input);
//			}catch(NullPointerException e){
//				//break;
//			}
//			
//			double t= Double.parseDouble(input)/max*100;
//			System.out.println(t);
//			
//			if(t<60) r++;
//			else if(t>60&&t<68) w++;
//			else if(t>68&&t<75) f++;
//			else if(t>75&&t<80) mid++;
//			else if(t>80&&t<90) h++;
//			else mh++;
//	//	}
//		
//		String result ="";
//		if(r!=0) result+=r+" ";
//		if(w!=0) result+=w+" ";
//		if(f!=0) result+=f+" ";
//		if(mid!=0) result+=mid+" ";
//		if(h!=0) result+=h+" ";
//		if(mh!=0) result+=mh+" ";
//		
//		System.out.println(result);		
//	}
//	}
	
	
	
//	public static long solution(String expression) {
//        long answer = 0;
//        int a= Integer.parseInt(expression);
//        System.out.println(a);
//        answer=a;
//        String[] ex =expression.split("*|+|-") ;
//        for(int i =0;i<ex.length;i++) {
//        	
//        }
//        return answer;
//        
//    }

//	public static int[] solution(String[] gems) {
//
//		Set<String> s = new LinkedHashSet<>();
//		for (int i = 0; i < gems.length; i++)
//			s.add(gems[i]);
//
//		Iterator<String> it = s.iterator();
//		String sit = "";
//		ArrayList<String> arr = new ArrayList<>();
//
//		while (it.hasNext()) {
//			sit = it.next();
//			arr.add(sit);
//		}
//
//		int idx = 0;
//		int start = 0;
//		int end = 0;
//		ArrayList<String> test1 = new ArrayList<>();
//
//		while (idx < arr.size()) {
//			test1 = new ArrayList<>();
//
//			for (int i = idx; i < gems.length; i++) {
//				test1.add(gems[i]);
//			}
//
//			for (int i = 0; i < arr.size(); i++) {
//				if (test1.contains(arr.get(i))) {
//					if (i == arr.size() - 1) {
//						System.out.println(idx + 1);
//						System.out.println(test1.size() + 1);
//						start = idx + 1;
//						end = test1.size() + 1;
//					}
//				} else {
//					break;
//				}
//			}
//
//			idx++;
//		}
//
//		/////////////
//		for (int i = 0; i < gems.length; i++) {
//			if (gems[i] == arr.get(arr.size() - 1)) {
//				if (end > i + 1)
//					end = i + 1;
//			}
//		}
//
//		for (int i = 0; i < gems.length - arr.size(); i++) {
//			System.out.println(gems[i]);
//			if (gems[i] == arr.get(0)) {
//				if (start > i + 1) {
//					for (int k = 0; k < arr.size(); k++) {
//						if ((test1.subList(i + 1, test1.size())).contains(arr.get(k))) {
//							if (k == arr.size() - 1) {
//								start = k + 1;
//								break;
//							}
//						} else {
//							break;
//						}
//					}
//				}
//			}
//			System.out.println(start);
//		}
//
////			for (int i = 0; i < gems.length; i++) {
////				if (gems[i] == arr.get(arr.size()-1)) {
////					if(end>i+1)
////					end = i+1;
////				}
////			}
//		int[] answer = { start, end };
//
//		System.out.println(start + "sss");
//		System.out.println(end + "sss");
//		return answer;
//	}

//	public static void main(String[] args) {
//		int[] answer = { 1, 2 };
//		System.out.println(answer.length);
//		String[] gems = { "AA", "AB", "AC", "AA", "AC" };
//		System.out.println(solution(gems));
//		 String answer = "";
//	        Scanner sc = new Scanner(System.in);
//	        
//	        char[][] arr= {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
//	       
//	        String numbers= sc.nextLine();
//	        String hand = sc.nextLine();
//
//	        Queue<Character> numbersQ = new LinkedList<>();
//	        for(int i=0;i<numbers.length();i++) {
//	        	numbersQ.add(numbers.charAt(i));
//	        }
//	        
//	        char lHand= arr[3][0];
//	        char rHand = arr[3][2];
//	        String lHandLoc ="30";
//	        String rHandLoc ="32";
//
//        	String numLoc = "";
//	        
//	        while(!numbersQ.isEmpty()) {
//	        	
//	        	char num= numbersQ.poll();
//	        	for(int i=0;i<arr.length;i++) {
//	        		for(int j=0;j<arr[i].length;j++)
//	        		{
//	        			if(Parse.Integer(arr[i][j]==num) {
//	        				numLoc=i+""+j;
//	        			}
//	        		}
//	        	}
//	        	
//	        	if(num=='1'||num=='4'||num=='7') {
//	        		lHand=num;
//	        		lHandLoc=numLoc;
//	        		answer+="L";
//	        		System.out.println("L");
//	        	}
//	        	else if(num=='3'||num=='6'||num=='9') {
//	        		rHand=num;
//	        		rHandLoc=numLoc;
//	        		answer+="R";
//	        		System.out.println("R");
//	        	}
//	        	//numLoc="1 1"
//	        	//leftLoc="0 0"
//	        	//rightLoc="0 2" 22
//	        	else {
//	        		int l=Math.abs(numLoc.charAt(0)-lHandLoc.charAt(0));
//	        		l+=Math.abs(numLoc.charAt(1)-lHandLoc.charAt(1));
//	        		int r=Math.abs(numLoc.charAt(0)-rHandLoc.charAt(0));
//	        		r+=Math.abs(numLoc.charAt(1)-rHandLoc.charAt(1));
//	        		
//	        		if(l>r) {
//	        			System.out.println("R");
//		        		answer+="R";
//	        			rHand=num;
//		        		rHandLoc=numLoc;
//	        		}else if(l<r) {
//	        			System.out.println("L");
//		        		answer+="L";
//	        			lHand=num;
//		        		lHandLoc=numLoc;
//	        		}else {
//	        			if(hand=="L") {
//	        				System.out.println("L");
//		        			lHand=num;
//			        		lHandLoc=numLoc;
//	        			}else {
//	        				System.out.println("R");
//		        			rHand=num;
//			        		rHandLoc=numLoc;
//	        			}
//	        		}
//	        		
//	        	
//	        }
//	        return answer;
//	        
		/*
		 * int[] arr= {1,3,4,2}; //삽입 for(int i=1;i<arr.length;i++) { int g=arr[i];
		 * for(int j=i-1;j>=0;j--) { if(g<arr[j]) { arr[j+1]=arr[j]; } } } for(int
		 * i=0;i<arr.length;i++) { System.out.println(arr[i]); }
		 */

		// 선택
		/*
		 * for(int i=0;i<arr.length-1;i++) { int min=i; for(int j=i+1;j<arr.length;j++)
		 * { if(arr[min]>arr[j]) { min=j; } } int t=arr[i]; arr[i]=arr[min]; arr[min]=t;
		 * }
		 */

		// 버블
		/*
		 * for(int i=0;i<arr.length-1;i++) { for(int j=0;j<arr.length-1;j++) {
		 * if(arr[j]>arr[j+1]) { int k=arr[j]; arr[j]=arr[j+1]; arr[j+1]=k; } } }
		 * 
		 */
//		System.out.println("스캐너");
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int hap = 0;
//		int j = 3;
//		while (true) {
//
//			int x = 2;
//			while (j % x != 0)
//				x++;
//
//			if (j == x) {
//				hap += j;
//			}
//			if (j < a) {
//				j++;
//			}
//			else {
//				System.out.println(hap);
//				break;
//			}
//		}

		/*
		 * int a, sum, i, j; a = 11; sum = 0; i = 2;
		 * 
		 * while (true) { // 무한루프 j = 2; while (i % j != 0) // i를 j로 나눈 나머지가 0 이아니라면
		 * 반복문을 수행합니다. j++;
		 * 
		 * if (i == j) { // i와 j가 같으면 sum의 값에 i를 누적시킵니다. sum += i; }
		 * 
		 * if (i < a) { // i가 a보다 작으면 i를 1증가시킵니다. i++; } else { System.out.println(sum);
		 * break; } }
		 */
	//}
//}

//import java.util.Stack;
//
//public class main {
//
//	public static void main(String[] args) {
//		Scanner sc =  new Scanner(System.in); 
//		String s=sc.next();
//		int a=solution(s);
//		System.out.println(a);
//	}
//
//	private static int solution(String s) {
//		Stack<Character> stack=new Stack<>();
//		int answer=0;
//		
//		for(int i=0;i<s.length();i++) {
//			char t=s.charAt(i);
//			if(t=='(') {
//				stack.push(t);
//			}else if(t==')') {
//				if(!stack.isEmpty()){
//					stack.pop();
//					answer++;
//				}else {
//					answer=-1;
//					break;
//				}
//					
//			}
//			else if(t=='<') {
//				stack.push(t);
//			}else if(t=='>') {
//				if(!stack.isEmpty()){
//					stack.pop();
//					answer++;
//				}
//				else{
//					answer=-1;
//					break;
//				}
//			}
//			else if(t=='{') {
//				stack.push(t);
//			}else if(t=='}') {
//				if(!stack.isEmpty()){
//					stack.pop();
//					answer++;
//				}
//				else{
//					answer=-1;
//					break;
//				}
//			}
//			
//			else if(t=='[') {
//				stack.push(t);
//			}else if(t==']') {
//				if(!stack.isEmpty()) {
//					stack.pop();
//					answer++;
//				}
//				else{
//					answer=-1;
//					break;
//				}
//			}
//			
//		}
//		
//		return answer;
//	}
//}
