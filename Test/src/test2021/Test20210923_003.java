package test2021;

import java.util.stream.IntStream;

/*
문제 설명
길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. 
a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.

이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)

제한사항
a, b의 길이는 1 이상 1,000 이하입니다.
a, b의 모든 수는 -1,000 이상 1,000 이하입니다.

입출력 예
a					b						result
[1,2,3,4]		[-3,-1,0,2]		3
[-1,0,1]		[1,0,-1]			-2

*/
public class Test20210923_003 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};

		long startTime = System.currentTimeMillis();
		
		int result = solution1(a, b);
//		System.out.println(result);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		startTime = System.currentTimeMillis();
		result = solution2(a, b); // solution2는 조금더 간단하게 코딩되지만 실행시간이 solution1에비해 느리네...
//		System.out.println(result);
		endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
	
	public static int solution1(int[] a, int[] b) {
        int answer = 0;
        // 내적 구하는 공식 : a[n-1]*b[n-1]
        
        for(int i = 0; i < a.length; i++) {
        	answer += a[i]*b[i];
        }
        
        return answer;
    }
	
	public static int solution2(int[] a, int[] b) {
        int answer = 0;
        // 내적 구하는 공식 : a[n-1]*b[n-1]
        answer = IntStream.range(0, a.length).map(index -> a[index]*b[index]).sum();
        return answer;
    }
	
	
}
