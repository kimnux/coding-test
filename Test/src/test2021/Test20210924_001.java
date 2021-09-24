package test2021;

import java.util.Arrays;

/*
K번째수
문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 
return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

입출력 예
array							commands									return
[1, 5, 2, 6, 3, 7, 4]		[[2, 5, 3], [4, 4, 1], [1, 7, 3]]		[5, 6, 3]
*/
public class Test20210924_001{
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4}; 
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		
		int [] result = solution2(array, commands);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
        	int from = commands[i][0]-1;
        	int to = commands[i][1];
        	
//       						  Arrays.copyOfRange(original, from, to) 사용 하면 조금더 간단해진다.
        	int[] temp = Arrays.copyOfRange(array, from, to);
        	Arrays.sort(temp);
        	answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
	
	public static int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int j = 0; j < commands.length; j++) {
        	int start = commands[j][0]-1;
        	int end = commands[j][1];
        	int peek = commands[j][2]-1;
        	
        	int[] temp = new int[end-start];
        	int index = 0;
        	
        	for(int i = start; i < end; i++) {
        		temp[index] = array[i];
        		index++;
        	}
        	
        	Arrays.sort(temp);
        	answer[j] = temp[peek];        
        }
        
        return answer;
    }
	
}