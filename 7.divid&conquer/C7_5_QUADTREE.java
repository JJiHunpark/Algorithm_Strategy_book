import java.io.*;

public class C7_5_QUADTREE {
	public static int C, position;
	
	public static String reverse(String quadTree) {
		// quadtree의 첫 글자가 x가 아닐 경우 해당 압축 코드를 리턴
		if(quadTree.charAt(position) != 'x') {
			position++;
			return quadTree.charAt(position-1) + "";
		}
		// quadtree의 첫 글자가 x일 경우 재귀 호출 수행
		position++;
		String upperLeft = reverse(quadTree);	// 1
		String upperRight = reverse(quadTree);	// 2
		String lowerLeft = reverse(quadTree);	// 3
		String lowerRight = reverse(quadTree);	// 4
		
		// 상하로 뒤집은 결과 3,4,1,2
		return "x"+ lowerLeft + lowerRight + upperLeft + upperRight;
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
			bw.write(reverse(quadTree) + "\n");
		}
		bw.close();
		
	}
	public static void main(String[] args) throws IOException{
		C7_5_QUADTREE.run();
	}
}
