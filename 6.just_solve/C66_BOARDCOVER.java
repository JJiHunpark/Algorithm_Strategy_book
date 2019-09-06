import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C66_BOARDCOVER {
	// 'ㄱ'자 블록을 놓을 수 있는 상대적 위치
	static int[][][] blockType = {
			{{0,0}, {0,1}, {1,0}},
			{{0,0}, {0,1}, {1,1}},
			{{0,0}, {1,0}, {1,1}},
			{{0,0}, {1,1}, {1,-1}},
	};
	static int[][] board;	// 게임판
	static int C, H, W;
	
	public static boolean set(int y, int x, int type, int act) {
		boolean check = true;
		// 'ㄱ'자 블록을 board에 놓아보기
		for(int i=0; i<3; i++) {
			int dy = y + blockType[type][i][0];
			int dx = x + blockType[type][i][1];
			if(dy<0 | dy>=board[0].length | dx<0 | dx>=board[0].length)	// 블록이 게임판으로 나갈 경우
				check = false;
			else if(board[dy][dx] + act > 1) // 블록이 겹치는 경우
				check = false;
		}
		return check;
	}
	
	public static void Boardcover() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		/* 1. 테스트 케이스 입력 */
		C = Integer.parseInt(br.readLine());
		assert C <= 30 : "Error :: C(testCase) <= 30";
		
		for(int tc=0; tc<C; tc++) {
			/* 2. H(Height)과 W(Width) 입력 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());  // 학생의 수
			W = Integer.parseInt(st.nextToken());  // 친구 쌍의 수
			assert 1 <= H | 1 <= W | H <= 20 | W <=2 : "Error :: 1 <= H,W <= 20";
		
			/* 3. board에 블럭을 저장 */
			board = new int[H][W];
			int countWhiteBlock = 0;
			for(int hg=0; hg<H; hg++) {
				StringTokenizer bk = new StringTokenizer(br.readLine());
				String tempString = bk.nextToken();
				for(int wd=0; wd<W; wd++) {
					char temp = tempString.charAt(wd);
					int block = (temp=='#') ? 1:0;
					if(block == 0)	countWhiteBlock++;
					board[hg][wd] = block;
				}
			}
			// 데이터가 잘 들어갔는지 출력해서 확인
//			for(int hg=0; hg<H; hg++) {
//				for(int wd=0; wd<W; wd++) {
//					bw.write(String.format("%d",board[hg][wd]));
//				}
//				bw.write("\n");
//			}
//			bw.write("\n");

			assert countWhiteBlock <= 50 : // 흰 칸이 50칸을 초과하면 에러 발생
				"Error :: countWhiteBlock <= 50";
			// 흰 칸이 3의 배수가 아닐 경우 0 출력 
			if(countWhiteBlock%3 != 0)
				bw.write(String.format("%d\n", 0));
			else
				bw.write(String.format("%d\n", cover()));
		}
		bw.close();
	}
	/* 4. board의 모든 빈 칸을 덮을 수 있는 방법의 수를 반환하는 함수 */
	public static int cover() {
		// 채우지 못 한 가장 위&왼쪽 에 있는 칸 탐색
		int y = -1, x = -1;
		for(int hg=0; hg<H; hg++) {
			for(int wd=0; wd<W; wd++) {
				if(board[hg][wd] == 0) {
					y = hg;
					x = wd;
					break;
				}
			}
			// 빈 칸을 찾았을 경우 반복문에서 탈출
			if(y != -1) break;	
		}
		// 모든 칸을 채웠을 경우 1 반환
		if(y == -1) return 1;
		int ret = 0;
		// 가장 위&왼쪽에 있는 빈 칸에 'ㄱ'블록을 덮을 4가지 방법을 시도
		for(int type=0; type<4; type++) {
			// board[y][x]를 해당 type으로 덮을 수 있다면 재귀 호출
			if(set(y, x, type, 1))
				ret += cover();
			// 덮을 수 없다면 덮었던 블록을 치우기
			set(y, x, type, -1);
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		C66_BOARDCOVER.Boardcover();
	}
}
