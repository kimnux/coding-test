package test2021;

public class Test20210913 {
	public static void main(String[] args) {
//						numbers				hand				result
//		[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
//		[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
//		[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
				
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		String result = solution(numbers, hand);
		System.out.println(result);
	}
	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        
        for(int number : numbers) {
        	if(number == 1  || number == 4  || number == 7) {
        		answer += "L";
        		left = number;
        	}else if(number == 3  || number == 6  || number == 9) {
        		answer += "R";
        		right = number;
        	} else {
        		int leftLen = getLength(number, left);
        		int rightLen = getLength(number, right);
        		
        		if(leftLen > rightLen) {
        			answer += "R";
        			right = number;
        		} else if(leftLen < rightLen) {
        			answer += "L";
        			left = number;
        		} else {
        			if(hand.equals("left")) {
                        answer += "L";
                        left = number;
                    }
        			else if(hand.equals("right")) {
                        answer += "R";
                        right = number;
                    }
        		}
        		
        	}
        }
        
        return answer;
    }
	
	public static int getLength(int number, int index) {
		number = (number == 0) ? 11 : number;
		index = (index == 0) ? 11 : index;	
		
		int x = (index - 1) % 3;
		int y = (index - 1) / 3;
		
		int numberX = 1;
		int numberY = number / 3;
		
		return Math.abs(x-numberX) + Math.abs(y-numberY);
	}
}
