import java.util.*;

public class C411 {
	static int MIN = Integer.MIN_VALUE;	// int형 최소값

	private static int fastestMaxSum(final ArrayList<Integer> A)
	{
		int N = A.size();
		int ret = MIN;
		int psum = 0;
		for (int i = 0; i < N; i++)
		{
			psum = Math.max(psum, 0) + A.get(i);
			ret = Math.max(psum, ret);
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
        
        int result = fastestMaxSum(al);
        System.out.println(result);
	}
}


/**
int fastestMaxSum(const vector<int>& A) {
	int N = A.size(), ret = MIN, psum = 0;
	for(int i=0; i<N; i++) {
		psum = max(psum, 0) + A[i];
		ret = max(psum, ret);
	}
	return ret;
}
**/