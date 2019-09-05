import java.util.ArrayList;

public class C49_1 {
	static int MIN = Integer.MIN_VALUE;	// int형 최소값

	private static int betterMaxSum(final ArrayList<Integer> A) {
		int N = A.size();
		int ret = MIN;
		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = i; j < N; ++j) {
				sum += A.get(j);
				ret = Math.max(ret, sum);
			}
		}
		return ret;
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
        
        int result = betterMaxSum(al);
        System.out.println(result);
	}
}


/**
int betterMaxSum(const vector<int>& A) {
	int N = A.size(), ret = MIN;
	for(int i=0; i<N; ++i) {
		int sum = 0;
		for(j=i; j<N; ++j) {
			sum += A[j];
			ret = max(ret, sum);
		}
	}
	return ret;
}
**/