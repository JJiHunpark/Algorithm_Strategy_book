import java.util.*;

/*
 n : 전체 원소의 수
 picked : 지금까지 고른 원소들의 번호
 toPick : 더 고를 원소의 수
 */
public class C62 {
	static int N=7;
	
	private static void pick(int n, ArrayList<Integer> picked, int toPick) {
		// 더 고를 원소가 없을 경우 고른 원소들을 출력
		if (toPick == 0) {
			printPicked(picked);
			return;
		}
		// 고를 수 있는 가장 작은 번호를 계산
		int smallest = picked.isEmpty() ? 0 : picked.get(picked.size()-1) + 1;
		// 원소를 하나 선택
		for (int next = smallest; next < n; next++) {
			picked.add(next);
			pick(n, picked, toPick-1);
			picked.remove(picked.size()-1);
		}
	}
	//picked에 저장된 원소 출력
	private static void printPicked(ArrayList<Integer> picked) {
		for(int i=0; i<picked.size(); i++) {
			System.out.print(picked.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayList<Integer> picked = new ArrayList<Integer>();
		pick(7, picked, 4);
	}
}

/*
void pick(int n, vector<int>& picked, int toPick) {
	if(toPick==0) { printPicked(picked); return; }
	int smallest = picked.empty() ? 0 : picked.back() + 1;
	for(int next=smallest; next<n; ++next) {
		picked.push_back(next);
		pick(n, picked, toPick-1);
		picked.pop_back();
	}
}
*/