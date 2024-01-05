package homework.programmers;

import java.util.regex.Pattern;

public class S120956 {

    //  Todo:
    //   1. 문자열을 요소로 가진 크기 15 이하의 배열
    //   2. 중복 사용 불가 -> 중복 체크하기
    //   3. 조합하여 나올 수 있는 단어의 개수 구하기

    private static final String[] PATTERNS = {"aya", "ye", "woo", "ma"};   // final 상수 배열 생성

    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        return (int) java.util.Arrays.stream(babbling)
                .filter(S120956::isValidBabbling)   //  .filter(클래스명::메서드명)
                .count();
    }

    // babbling 배열에 있는 각 문자열 요소를 매개변수 String word로 본다.
    // isValidBabbling() 메서드: 각 문자열이 유효한지 검사하는 메서드
    private static boolean isValidBabbling(String word) {
        String pattern = String.join("|", PATTERNS);
        String replacedWord = word.replaceAll(pattern, "");
        return replacedWord.isEmpty() && Pattern.matches("((" + pattern + ")+)", word);
    }
}
//        int result = 0;
//
//        String[] str = {"aya", "ye", "woo", "ma"};
//        for (int i = 0; i < str.length; i++) {
//            for (int j = 0; j < babbling.length; j++) {
//                if (babbling[j].contains(str[i])) {
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//}
/** 오류:
 *  1이 출력되어야 하는데 4가 출력된다.
 *  3이 출력되어야 하는데 8이 출력된다.
 */
