package test2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

//1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
//가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

//제한 조건
//시험은 최대 10,000 문제로 구성되어있습니다.
//문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
public class Test20210916 {
	public static void main(String[] args) {
		/*
		[1,2,3,4,5]	[1]
		[1,3,2,4,2]	[1,2,3]
		*/
		int[] answers = {1, 2, 3, 4, 5};
		int[] result = solution(answers);
		
		System.out.println(Arrays.toString(result));
		
	}
	
	public static int[] solution(int[] answers) {
        int[] answer = {};
        
        int person1[] = {1, 2, 3, 4, 5};
        int person2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int person3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == person1[i%5]) cnt1++;
        	if(answers[i] == person2[i%8]) cnt2++;
        	if(answers[i] == person3[i%10]) cnt3++;
        }
        
        int max = Integer.max(cnt1, cnt2);
        max = Integer.max(max, cnt3);
        
        List<Integer> list = new ArrayList<>();
        
        if(max == cnt1) list.add(1);
        if(max == cnt2) list.add(2);
        if(max == cnt3) list.add(3);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
	
}
