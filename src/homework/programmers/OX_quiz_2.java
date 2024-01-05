package homework.programmers;

import java.util.Arrays;

public class OX_quiz_2 {
    // 정적 상수 선언
    private static final String CORRECT = "O";
    private static final String INCORRECT = "X";

    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        System.out.println(Arrays.toString(solution(quiz)));
    }

    // 배열 stream 사용
    public static String[] solution(String[] quiz) {
        return Arrays.stream(quiz)
                .map(OX_quiz_2 :: isCorrectExpression)
                .map(correct -> correct ? CORRECT : INCORRECT)
                .toArray(String[] :: new);
    }

    // 주어진 문자열을 공백을 기준으로 분할하여 배열로 저장하고, 각 피연산자와 연산자를 추출하여 정수형으로 변환하는 메서드
    public static boolean isCorrectExpression(String expression) {
        String[] parts = expression.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[2]);
        int z = Integer.parseInt(parts[4]);
        String operator = parts[1];

        int result = operator.equals("+") ? x + y : x - y;
        return result == z;

    }
}
