package test2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test20210906 {
	/*
	입출력 예
	N	stages	result
	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	4	[4,4,4,4,4]	[4,1,2,3]
	입출력 예 설명
	입출력 예 #1
	1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.

	1 번 스테이지 실패율 : 1/8
	2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.

	2 번 스테이지 실패율 : 3/7
	마찬가지로 나머지 스테이지의 실패율은 다음과 같다.

	3 번 스테이지 실패율 : 2/4
	4번 스테이지 실패율 : 1/2
	5번 스테이지 실패율 : 0/1
	각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

	[3,4,2,1,5]
	입출력 예 #2

	모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.

	[4,1,2,3]
	 */
	public static void main(String[] args) {
		int[] stages =  {2, 1, 2, 6, 2, 4, 3, 3};
//		int[] stages =  {4, 4, 4, 4, 4};
		solution(5, stages);
		
	}

	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] failPer = new int[N];
        int denominator = stages.length;
        
        for(int i = 0; i < stages.length; i++) {
        	for(int j = 1; j <= N; j++) {
        		if(stages[i] == j) {
        			failPer[j-1] += 1;
        			break;
        		}
        	}
        }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < failPer.length; i++) {
        	if(i > 0) denominator = (denominator-failPer[i-1]);
        	System.out.println(i+1 + "단계 : " + failPer[i] + "/" + denominator);
        	map.putIfAbsent((i+1)+"", failPer[i]*100/denominator);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
        	
        });
        
        int cnt = 0;
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            answer[cnt] = Integer.parseInt(entry.getKey());
            cnt++;
        }
        System.out.println("answer : "+Arrays.toString(answer));
        
        return answer;
    }

}
