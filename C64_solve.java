import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C64_solve {
	static int C;
	static int N;
	static int M;
	static boolean areFriend[][];
	
	public static void Picnic() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1. 테스트 케이스 입력
		C = Integer.parseInt(br.readLine());
		assert C < 50 : "Error :: C(testCase) <= 50";
		
		for(int tc=0; tc<C; tc++) {
			// 2. N(학생 수)과 M(친구 쌍의 수) 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 학생의 수
			M = Integer.parseInt(st.nextToken());  // 친구 쌍의 수
			assert N>2 | N<10 | M>0 | M<((N*(N-1))/2) : "Error :: 2 <= N <= 10, 0 <= M <= n(n-1)/2";
			
			// 3. M개의 쌍으로 이루어진 서로 친구인 학생들의 번호를 friend 배열에 저장
			areFriend = new boolean[N][N];
			StringTokenizer frd = new StringTokenizer(br.readLine());
			while(frd.hasMoreTokens()) {
				int f1 = Integer.parseInt(frd.nextToken());
				int f2 = Integer.parseInt(frd.nextToken());
				assert f1>=0 | f1<N | f2>=0 | f2<N : "Error :: 0 <= number < N";
				areFriend[f1][f2] = areFriend[f2][f1] = true;
			}
			
			// 4. N명의 학생을 친구끼리만 짝지어줄 수 있는 방법의 수 출력
			boolean[] bePaired = new boolean[N];
			bw.write(String.format("%d\n", countPairings(bePaired)));
		}	
		bw.close();
	}
	
	public static int countPairings(boolean[] bePaired) {
		// 기저 사례 1. 남은 학생들 중 가장 번호가 빠른 학생 선택(중복 방지)
		int fastNum = -1;
		for(int i=0; i<N; i++) {
			if(!bePaired[i]) {
				fastNum = i;
				break;
			}
		}
		// 기저 사례 2. 모든 학생이 짝을 찾으면 한 가지 방법을 찾았으니 종료
		if(fastNum == -1) return 1;
		// 기저 사례 3. 서로 짝도 없고, 친구 관계일 경우 재귀 호출을 사용
		int ret = 0;
		for(int w=fastNum+1; w<N; w++) {
			if(!bePaired[w] & areFriend[fastNum][w]) {	// areFriend == TRUE 로 짝이 없고, 친구 관계일 경우
				bePaired[fastNum] = bePaired[w] = true;
				ret += countPairings(bePaired);
				bePaired[fastNum] = bePaired[w] = false;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		C64_solve.Picnic();
	}
}
