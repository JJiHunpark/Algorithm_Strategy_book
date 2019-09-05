import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class C63_solve {
	static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
	static ArrayList<String> board = new ArrayList<String>();
	static int C;	// number of testcase
	static int N;	// number of word
	
	public static void run() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 테스트 케이스 수 입력받기
		C = Integer.parseInt(br.readLine());
		if(C > 50) {
			bw.write("Error :: C(testCase) <= 50");
			bw.flush();
			System.exit(0);
		}
		
		for(int tc=0; tc<C; tc++) {
			// 2. 게임판 생성
			for(int input=0; input<5; input++) {
				board.add(br.readLine());
			}
			// 3.단어의 수 입력 받기
			N = Integer.parseInt(br.readLine());
			if(N<1 || N>10) {
				bw.write("Error :: 1 <= N(number of word) <= 10");
				System.exit(0);
			}
			// 4. 단어를 입력받은 후 hasWord함수에서 단어 여부 확인
			for(int now=0; now<N; now++) {
				String word = br.readLine();
				boolean ret = false;
				for(int y=0; y<5; y++) {
					for(int x=0; x<5; x++) {
						ret = hasWord(y,x,word);
						if(ret==true) break;
					}
					if(ret==true) break;
				}
				// 6. 결과 출력 
				bw.write(String.format("%s %s\n", word, ret?"YES":"NO"));
			}
		}
		bw.close();
	}
	// 5. 입력된 단어가 게임판에 있는지 확인하는 함수 
	public static boolean hasWord(int y, int x, String word) {
		// 기저 사례 1 : 범위를 벗어난 경우
		if(y<0 || y>4 || x<0 || x>4) return false;
		// 기저 사례 2 : 단어의 첫 글자가 일치하지 않을 경우
		if(board.get(y).charAt(x) != word.charAt(0)) return false;
		// 기저 사례 3 : 단어 길이가 1일  경우
		if(word.length() == 1) return true;
		// 인접한 칸을 검사
		for(int dir=0; dir<8; dir++) {
			int surY = y + dy[dir];
			int surX = x + dx[dir];
			if(hasWord(surY, surX, word.substring(1)))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		C63_solve.run();
	}
}
