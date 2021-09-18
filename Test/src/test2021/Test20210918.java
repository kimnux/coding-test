package test2021;

import java.util.Arrays;

/*
 문제 설명
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 
 
 입출력 예
nums				result
[1,2,3,4]			1
[1,2,7,6,4]		4
*/
public class Test20210918 {

	public static void main(String[] args) {
		int[] nums = {1,2,7,6,4};
		int result = solution(nums);
		System.out.println(result);
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
        	for(int j = i+1; j < nums.length-1; j++) {
        		for(int k = j+1; k < nums.length; k++) {
//        			System.out.println(nums[i]+"+" + nums[j] + "+" + nums[k]);
        			boolean isPrimeNumber = isPrimeNumber(nums[i] + nums[j] + nums[k]);
        			if(isPrimeNumber) answer++; 
        		}
        	}
        }
        return answer;
    }
	
	public static boolean isPrimeNumber(int number) {
		for(int i = 2; i <= Math.sqrt(number); i++) { // 시간복잡도 O(N√N)
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
