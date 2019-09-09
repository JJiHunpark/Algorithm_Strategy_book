class SquareMatrix {
	// 정방행렬을 표현하는 SquareMatrix class
}

public class C7_2 {
	public static SquareMatrix identity(int n) {
		// n * n 크기의 항등 행렬을 반환하는 함수
	}
	
	public static SquareMatrix pow(SquareMatrix S, int m) {
		if(m == 0) return new SquareMatrix(identity(S.size());
		if(m%2 > 0) return pow(S, m-1) * S;  // 거듭제곱이 홀수일 경우 m-1 
		SquareMatrix half = pow(S, m/2);  // 거듭제곱이 짝수일 경우 절반으로 분할
		// A^m = (A^(m/2)) * (A^(m/2))
		return half * half;  // 최종으로 2분할된 행렬을 제곱
	}
	
	public static void main(String[] args) {
		SquareMatrix matrx = new SquareMatrix(5);
		pow(matrx, 10);
	}
}
