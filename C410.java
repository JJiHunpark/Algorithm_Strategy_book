import java.util.*;

public class C410 {
	static int MIN = Integer.MIN_VALUE;	// int형 최소값

	// A[lo ~ hi] 의 연속된 부분 구간의 최대 합
	private static int fastMaxSum(final ArrayList<Integer> A, int lo, int hi) {
		if (lo == hi) return A.get(lo);		// 구간의 길이가 1일 경우
		int mid = (lo + hi) / 2;		// 배열을 두 조각으로 분할

		// 분할된 두 부분에 모두 걸쳐 있는 최대 합 구간을 탐색, A[i~mid]와 A[mid+1~j] 형태를 갖는 구간의 합
		int left = MIN, right = MIN;
		// A[i~mid] 형태를 갖는 최대 구간 탐색 
		int sum = 0;
		for (int i = mid; i >= lo; i--) {
			sum += A.get(i);
			left = Math.max(left, sum);
		}
		// A[mid+1~j] 형태를 갖는 최대 구간 탐색 
		sum = 0;
		for (int j = mid + 1; j <= hi; j++) {
			sum += A.get(j);
			right = Math.max(right, sum);
		}
		// 최대 구간이 분할된 두 조각 중 한 구간만 속해 있는 경우
		int single = Math.max(fastMaxSum(A, lo, mid), fastMaxSum(A, mid + 1, hi));
		// 두 경우의 최대치 반환
		return Math.max(left + right, single);
	}

	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(-7);
        al.add(4);
        al.add(-3);
        al.add(6);
        al.add(3);
        al.add(-8);
        al.add(3);
        al.add(4);
        
        int result = fastMaxSum(al, 0, al.size()-1);
        System.out.println(result);
	}
}


/**
// A[lo ~ hi] 의 연속된 부분 구간의 최대 합
int fastMaxSum(const vector<int>& A, int lo, int hi) {
	if(lo == hi) return A[lo];	
	int mid = (lo + hi) / 2;

	int left = MIN, right = MIN, sum = 0;
	
	for(int i=mid; i>=lo; --i) {
		sum += A[i];
		left = max(left, sum);
	}
	
	sum = 0;
	for(int j=mid+1; j>=hi; ++i) {
		sum += A[j];
		left = max(right, sum);
	}

	int single = max(fastMaxSum(A, lo, mid), fastMaxSum(A, mid+1, hi));

	return max(left + right, single);
}
**/