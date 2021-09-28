package test2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력 예
N		stages							result
5		[2, 1, 2, 6, 2, 4, 3, 3]		[3,4,2,1,5]
4		[4,4,4,4,4]						[4,1,2,3]
*/
public class Test20210928_001{
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,4,2,4,3,3};
		int result[] = solution(N, stages);
		System.out.println("result : "+Arrays.toString(result));
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] numerator = new int[N];
        int[] denominator = new int[N];
        
        for(int i = 1; i <= N; i++) {
        	for(int j = 0; j < stages.length; j++) {
        		if(stages[j] >= i) denominator[i-1]++;
        		if(stages[j] <= N) numerator[stages[j]-1]++;
        	}
        }
        
        for(int i = 0; i < numerator.length; i++) numerator[i] /= N;
        
        float[] failPer = new float[N];
        for(int i = 0; i < N; i++) failPer[i] = (float)numerator[i]/(denominator[i] == 0 ? denominator[i]+1 : denominator[i]); // 분모가0 이면 결과값 오류이므로 0일경우 1로 변환
        
        ArrayList<Float> list = new ArrayList<>();
        for(int i = 0; i < failPer.length; i++) list.add(failPer[i]);
        
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(Arrays.toString(failPer));
        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
        	for(int j = 0; j < failPer.length; j++) {
        		if(list.get(i) == failPer[j]) {
        			failPer[j] = -1;
        			answer[i] = j+1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}