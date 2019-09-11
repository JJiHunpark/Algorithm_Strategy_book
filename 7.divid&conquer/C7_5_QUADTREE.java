import java.io.*;

public class C7_5_QUADTREE {
	public static int C, position;
	
	public static String reverse(String quadTree) {
		// quadtree의 첫 글자가 x가 아닐 경우 해당 코드를 리턴 
		if(quadTree.charAt(position) != 'x') {	
			position++;
			return quadTree.charAt(position-1) + "";
		}
		else
			
	}
	
	public static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		/* input a test case  */
		C = Integer.parseInt(br.readLine().trim());
		assert C <= 50 : "Error :: testCase must be no more than 50.";
		
		while(C-->0) {	// start testCase
			/* input a quadTree */
			String quadTree = br.readLine().trim();
			assert quadTree.length() <= 1000 : "Error :: quadtree must be no more than 1,000.";
			
			position = 0;
			bw.write(reverse(quadTree));
		}
		bw.close();
		
	}
	public static void main(String[] args) throws IOException{
		C7_5_QUADTREE.run();
	}
}
