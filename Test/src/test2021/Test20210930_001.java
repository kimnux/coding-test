package test2021;

/*
폰켓몬

제한사항
nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.

입출력 예
nums				result
[3,1,2,3]				2
[3,3,3,2,2,4]		3
[3,3,3,2,2,2]		2
*/

import java.util.HashSet;

public class Test20210930_001{
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,2};
		int result = solution(nums);
		System.out.println("result => "+result);
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        
        System.out.println("nums길이 : "+nums.length);
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) set.add(num);
        System.out.println("set길이 : "+set.size());
        
        if(nums.length/2 < set.size()) {
        	System.out.println("result : "+nums.length/2);
        	answer = nums.length/2;
        }else {
        	System.out.println("result : "+set.size());
        	answer = set.size();
        }
        
        return answer;
    }
}