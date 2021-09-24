package test2021;

import java.util.Arrays;

/*
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 
체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 
매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

*/

public class Test20210924_002 {
	public static void main(String[] args) {

		/*
		 * 입출력 예 	n 		lost 			reserve 		return 
		  					5 		[2, 4] 		[1, 3, 5] 		5 
		  					5		[2, 4] 		[3] 				4
		  					3 		[3] 			[1] 				2
		 */
		/*
		추가 테스트 케이스
		체육복을 잃어버린 친구가 여분을 가지고 있는 경우, 즉 lost에도 reserve에도 포함되는 경우
		"체육복을 빌려줄 수 없다"는 조건에 의해 아래 테케를 통과해야합니다
		
		n=5, lost=[1,2,3], reserve=[2,3,4]
		답: 4
		n=5, lost=[2,3,4], reserve=[1,2,3]
		답: 4
		*/
		int n = 5;
		int[] lost = { 1,2,3 };
		int[] reserve = { 1,2,3 };

		int result = solution(n, lost, reserve);
		System.out.println(result);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		Arrays.sort(lost); // 안할시 테스트 케이스에서 통과 못함.
		Arrays.sort(reserve); // 안할시 테스트 케이스에서 통과 못함.

		int[] status = new int[n];
		
		for(int i = 0; i < lost.length; i++) {
			int searchIndex = Arrays.binarySearch(reserve, lost[i]);
			if(searchIndex > -1) {
				System.out.println("searchIndex : " + searchIndex);
				reserve[searchIndex] = 0;
				lost[i] = 0;
			}
		}
		
		for(int i = 0; i < lost.length; i++) {
			if(lost[i] != 0) status[lost[i]-1] = -1;
		}
		for(int i = 0; i < reserve.length; i++) {
			if(reserve[i] != 0) status[reserve[i]-1] = 1;
		}
		
		
		for(int i = 0; i < status.length; i++) {
			if(i == 0 && (status[i] == 1 && status[i+1] == -1 || status[i] == -1 && status[i+1] == 1)) {
				status[i] = 0;   
				status[i+1] = 0;
			} else if(i == status.length-1 && status[i] == -1 && status[i-1] == 1) {
				status[i-1] = 0;
				status[i] = 0;
			} else if(i != 0 && i != status.length-1){
				if(status[i] == -1 && status[i-1] == 1) {
					status[i-1] = 0;
					status[i] = 0;
				}else if(status[i] == -1 && status[i+1] == 1) {
					status[i+1] = 0;
					status[i] = 0;
				}
			}
		}
		
		int cnt = 0;
		for(int i : status) if(i == -1) cnt++;
		
		answer = n-cnt;
		return answer;
	}

	

}
