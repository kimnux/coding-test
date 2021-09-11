package test2021;

public class Test20210911 {

	/*
	네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

	다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
	
	1478 → "one4seveneight"
	234567 → "23four5six7"
	10203 → "1zerotwozero3"
	
	참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

	숫자	영단어
	0	zero
	1	one
	2	two
	3	three
	4	four
	5	five
	6	six
	7	seven
	8	eight
	9	nine
	*/
	
	public static void main(String[] args) {
		/*
		 입출력 예
			"one4seveneight"	1478
			"23four5six7"	234567
			"2three45sixseven"	234567
			"123"	123
		*/
		
		int result = solution("one4seveneight");
		System.out.println(result);
	}
	
    public static int solution(String s) {
        int answer = 0;
       
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < numStr.length; i++) {
        	if(s.indexOf(numStr[i]) >= 0) s = s.replaceAll(numStr[i], i+"");
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
	
}
