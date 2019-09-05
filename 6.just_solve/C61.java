public class C61 {
	// 1. for문을 사용할 경우
	private static int sum(int n){
		int ret = 0;
		for (int i = 1; i <= n; ++i){
			ret += i;
		}
		return ret;
	}
	// 2. 재귀 호출을 사용할 경우
	private static int recursiveSum(int n){
		if (n == 1)	return 1;
		return n + recursiveSum(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(sum(7));
		System.out.println(recursiveSum(7));
	}
}
