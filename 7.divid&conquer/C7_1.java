public class C7_1 {
	public static int fastSum(int num) {
		if(num == 1) return 1;
		// 홀수일 경우, 짝수인 n-1번째 까지의 합을 재귀 호출로 구한 후 마지막에 num을 더해줌
		if(num % 2 == 1) return fastSum(num-1) + num;	
		// 짝수일 경우 더 작은 부분으로 분할하여 재귀 호출
		return 2*fastSum(num/2) + (num/2)*(num/2);	
	}
	public static void main(String[] args) {
		System.out.println(fastSum(10));
	}
}