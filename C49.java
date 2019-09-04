import java.util.*;

public class C49 {
	static int MIN = Integer.MIN_VALUE;	// int형 최소값

	private static int inefficientMaxSum(final ArrayList<Integer> A){
		int N = A.size();
		int ret = MIN;
		for (int i = 0; i < N; i++) 
			for (int j = i; j < N; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++){
					sum += A.get(k);
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
        
        int result = inefficientMaxSum(al);
        System.out.println(result);
	}
}



/**
const int MIN = numeric_limits<int>::min();
int inefficientMaxSum(const vector<int>& A) {
	int N = A.size(), ret = MIN;
	for(int i=0; i<N; ++i) {
		for(j=i; j<N; ++j) {
			int sum=0;
			for(int k=i; k<=j; ++k)
				sum += A[k]
			ret = max(ret, sum);
		}
	return ret;
	}
}
**/