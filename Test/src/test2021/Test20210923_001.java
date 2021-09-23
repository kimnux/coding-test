package test2021;

/*
없는 숫자 더하기

문제 설명
0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다. 
numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 9
0 ≤ numbers의 모든 수 ≤ 9
numbers의 모든 수는 서로 다릅니다.

입출력 예
numbers					result
[1,2,3,4,6,7,8,0]		14
[5,8,4,0,6,7,9]			6
*/

public class Test20210923_001 {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		int result = solution(numbers);
		System.out.println(result);
	}
	
	public static int solution(int[] numbers) {
        int answer = -1;
        
        int addAll = 0;
        for(int i = 1; i <= 9; i++) addAll += i;

        int addNum = 0;
        for(int num : numbers) addNum += num;
        
        answer = addAll - addNum;
        
        return answer;
    }
}
