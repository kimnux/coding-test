package test2021;

public class Test20210908 {
	/*
	새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 
	입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
	
	아이디의 길이는 3자 이상 15자 이하여야 합니다.
	아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
	단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	
	1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	
	[문제]
	신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
	
	[제한사항]
	new_id는 길이 1 이상 1,000 이하인 문자열입니다.
	new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
	new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.	
	*/
	public static void main(String[] args) {
		/*
		예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
		예2	"z-+.^."	"z--"
		예3	"=.="	"aaa"
		예4	"123_.def"	"123_.def"
		예5	"abcdefghijklmn.p"	"abcdefghijklmn"
		*/
		String new_id = "........................";
		String result = solution(new_id);
		
		System.out.println(result);
	}
	
	public static String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase(); 

        // 2단계
        StringBuilder  result = new StringBuilder();
        for(int i = 0; i < (new_id.length()); i++) {
        	if(String.valueOf(new_id.charAt(i)).matches("[a-z0-9-_.]")) {
        		result.append(new_id.charAt(i));
        	}
        }
        
        // 3단계
        int len = result.length();
        for(int i = 1; i < len; i++) {
        	if(result.charAt(i-1) == '.' && result.charAt(i) == '.') {
        		result.setCharAt(i-1, ' ');
        	}
        }
        answer = result.toString().replaceAll(" ", "");
        
        // 4단계
        int firstIndex = answer.indexOf(".", 0);
        if(firstIndex == 0) answer = answer.substring(1);
        int lastIndex = answer.lastIndexOf(".");

        if(answer.length() == 0) {// 5단계
        	
        	for(int i = 0; i < 3; i++) {
        		answer += "a";
        	}
        } else if(lastIndex == answer.length()-1) {// 4단계
        	answer = answer.substring(0, lastIndex);
        }
        // 6단계
        if(answer.length() > 15) {
        	answer = answer.substring(0, 15);
        	
        	lastIndex = answer.lastIndexOf(".");
        	if(lastIndex == answer.length()-1) {
            	answer = answer.substring(0, lastIndex);
            }
        }
        
        // 7단계
        len = answer.length();
    	char ch = answer.charAt(answer.length()-1);
    	for(int i = 0 ; i < 3; i++) {
    		if(len < 3) {
    			answer +=ch;
    			len = answer.length();
    		}
    	}
        
        return answer;
    }
}
