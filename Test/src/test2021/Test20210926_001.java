package test2021;

/*
3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. 
n을 3진법 상에서 앞뒤로 뒤집은 후, 
이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.

입출력 예
n			result
45		7
125		229
*/
public class Test20210926_001{
	public static void main(String[] args) {
		int n = 45;
		solution(n);
	}
	
	public static int solution(int n) {
        int answer = 0;
        
        String str = "";
//        str = Integer.toString(n, 3) // 좀더 간단히 변환 가능
        while(n > 0) {
        	str = (n%3)+str;
        	n /= 3;
        }
        
        String reverseStr = "";
        for(int i = str.length()-1; i >= 0; i--) reverseStr += str.charAt(i);
        
        answer = Integer.parseInt(reverseStr, 3);
        
        return answer;
    }
}