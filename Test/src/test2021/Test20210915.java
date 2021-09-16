package test2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

participant																			completion													return
["leo", "kiki", "eden"]															["eden", "kiki"]											"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]					["josipa", "filipa", "marina", "nikola"]		"vinko"
["mislav", "stanko", "mislav", "ana"]									["stanko", "ana", "mislav"]						"mislav"
*/

public class Test20210915 {
	public static void main(String[] args) {
		
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String result = solution2(participant, completion);
		System.out.println(result);
	}
	// 효율성 테스트 0점
	public static String solution(String[] participant, String[] completion) {
		System.out.println("solution1");
		String answer = "";
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < participant.length; i++) list.add(participant[i]);
		
		for(int i = 0; i < completion.length; i++) {
			if(list.contains(completion[i])) {
				int index = list.indexOf(completion[i]);
				list.remove(index);
			}
		}
		answer = list.get(0);
		return answer;
	}
	
	// 성공
	public static String solution2(String[] participant, String[] completion) {
		System.out.println("solution2");
		String answer = "";
		
		Arrays.sort(participant);
		Arrays.sort(completion);
		
		for(int i = 0; i < completion.length; i++) {
			if(!completion[i].equals(participant[i])) {
				answer = participant[i]; 
				break;
			} else {
				answer = participant[participant.length-1];
			}
		}
		
		return answer;
	}
}

	
    




