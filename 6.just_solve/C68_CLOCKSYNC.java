import java.io.*;
import java.util.StringTokenizer;

public class C68_CLOCKSYNC {
	public static int[] clocksNow;
	public static int C, INF=9999, SWITCH=10, CLOCKS=16;
	/* 스위치와 연결된 시계 정보 */
	public static int[][] linkedClock = {
			{0, 1, 2}, 
			{3, 7, 9, 11},
			{4, 10, 14, 15},
			{0, 4, 5, 6, 7},
			{6, 7, 8, 10, 12},
			{0, 2, 14, 15},
			{3, 14, 15},
			{4, 5, 7, 14, 15},
			{1, 2, 3, 4, 5},
			{3, 4, 5, 9, 13}
	};
	// 모든 시계가 12시를 가리키는지 확인 
	public static boolean areAligned() {
		int checkSum = 0;
		for(int ck=0; ck<CLOCKS; ck++) {
			checkSum += clocksNow[ck];
		}
		if (checkSum == 12*CLOCKS)
			return true;
		else
			return false;
	}
	// 스위치를 눌러 시간을 변경해주는 함수 
	public static void push(int swtch) {
		for(int ck=0; ck<linkedClock[swtch].length; ck++) {
			// 스위치에 연결된 시계가 어떤건지 확인
			int nClock = linkedClock[swtch][ck];
			clocksNow[nClock] += 3;
			if(clocksNow[nClock] == 15) clocksNow[nClock] = 3;
		}
	}
	
	public static int readySwitch(int swtch) {
		// 스위치를 다 눌러보았을 경우
		if(swtch == SWITCH) return areAligned() ? 0 : INF;
		// switch를 0번 누르는 경우부터 3번 누르는 경우까지
		int ret = INF;
		for(int cnt=0; cnt<4; cnt++) {
			ret = Math.min(ret, cnt+readySwitch(swtch+1));
			push(swtch);
		}
		return ret;
	}
	
	public static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* 테스트 케이스 입력 */
		C = Integer.parseInt(br.readLine().trim());
		assert C <= 30 : "Error :: testCase must be no more than 30.";
		
		while(C-->0) {	// start testCase
			clocksNow = new int[CLOCKS];
			/* 16개 시계의 시간 입력 (12, 3, 6, 9 중 하나) */
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int i=0; i<CLOCKS; i++) {
				int tempClock = Integer.parseInt(st.nextToken());
				assert tempClock==12 || tempClock==3 || tempClock==6 || tempClock==9 :
					"Time can be inputted 3, 6, 9, 12";
				clocksNow[i] = tempClock;
			}
			/* 스위치 눌러보기 */
			int result = readySwitch(0);
			bw.write(String.format("%d\n", result>INF?-1:result));
		}
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		C68_CLOCKSYNC.run();
	}
}
