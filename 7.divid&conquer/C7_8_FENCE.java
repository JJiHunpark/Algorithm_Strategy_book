import java.io.*;
import java.util.StringTokenizer;

public class C7_8_FENCE {
	public static int N;
	public static int[] height; // store the height of the board
	
	public static int division(int left, int right) {
		// 기저 사례  1 : 판자가 하나일 경우, 그 판자의 너비(높이x1)를 return
		if(left == right)
			return height[left];
		// 2. 가장 큰 직사각형이 왼쪽 혹은 오른쪽에 있을 경우
		// 판자를 반으로 분할
		int mid = (left + right) / 2;
		// 분할한 판자를 재귀호출
		int ret = Math.max(division(left, mid), division(mid+1, right));
		// 왼쪽 혹은 오른쪽에서 가장 큰 직사각형을 찾은 후 
		// 3. 가장 큰 직사각형이 왼쪽 부분 오른쪽 부분 모두에 걸쳐 있을 경우와  비교
		int lo=mid, hi=mid+1;
		
		return ret;
	}
	
	public static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* input a test case */
		int C = Integer.parseInt(br.readLine().trim());
		assert C <= 50 : "Error :: test case must be no more than 50.";
		
		while(C-->0) {
			/* input the number of boards */
			N = Integer.parseInt(br.readLine().trim());
			assert N >= 1 || N <= 20000 : "Error :: the number of boards must be no more than 20,000.";
			height = new int[N];
			
			/* input the height of the board */
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int i=0; i<N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				assert temp >= 0 || temp <= 10000 : "Error :: height must be no more 10,000";
				height[i] = temp;
			}
			/*
			validation inputed values 
			for(int i=0; i<N; i++) {
				System.out.print(height[i]);
			}
			*/
			int result = division(0, N-1);
			bw.write(result);
		}
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		C7_8_FENCE.run();
	}
}
