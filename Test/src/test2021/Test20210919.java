package test2021;

import java.util.Stack;

// 크레인 인형뽑기 게임
// https://programmers.co.kr/learn/courses/30/lessons/64061

/*
게임 화면의 격자의 상태가 담긴 2차원 배열 board와 
인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 
크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.

[제한사항]
board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
0은 빈 칸을 나타냅니다.
1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
moves 배열의 크기는 1 이상 1,000 이하입니다.
moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

입출력 예
board																											moves						result
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]			[1,5,3,5,1,2,1,4]			4
*/
public class Test20210919 {
	public static void main(String[] args) {
		int[][] board = {
									{1,1,1,1,0},
									{1,1,1,1,0},
									{1,1,1,1,0},
									{1,1,1,1,0},
									{1,1,1,1,0}
									}; 
		int[] moves = {1,1,1,1};
		
		int result = solution(board, moves);
		System.out.println(result);
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        
        for(int i = 0; i < moves.length; i++) {
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][moves[i]-1] != 0) {
        			basket.push(board[j][moves[i]-1]);
        			board[j][moves[i]-1] = 0;
        			break;
        		}
        	}
        }
        System.out.println(basket);
        int cnt = 0;
        int item = 0;
        while(item < basket.size()-1) {
        	if(basket.get(item) == basket.get(item+1)) {
	    		cnt += 2;
	    		basket.remove(item);
	    		basket.remove(item);
	    		item -= 2;
	    		if( item < 0) item = 0;
        	}else {
        		item++;
        	}
        }
        
        answer = cnt;
        
        return answer;
    }
}
