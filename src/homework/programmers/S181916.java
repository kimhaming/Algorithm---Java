package homework.programmers;

public class S181916 {
    public static void main(String[] args) {
        System.out.println(solution(2, 2, 5, 6));
    }

    public static int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        int score = 0;
        int p, q = 0;

        //  c1: a,b,c,d 가 모두 같을 경우이기 때문에 어떤 값이 a일지 b일지는 구할 필요가 없다.
            if (a == b && b == c && c == d) {
                p = a;
                score = 1111 * p;
            }
            // c2: 1개의 숫자만 다를 경우, 다른 숫자가 나올 경우는 4가지이므로 그 경우에 따라 q를 정하는 함수를 따로 만들어 사용
            else if ((a == b && b == c && c != d) ||
                    (a == b && b == d && d != c) ||
                    (a == c && c == d && d != b) ||
                    (b == c && c == d && d != a)) {

                // 숫자 한 개만 다른 숫자 찾아내기 함수 만들어서 사용
                q = findDifferentNumber(a, b, c, d);
                score = (int) (Math.pow(10 * a + q, 2));
            }
            // c3
            else if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
                if (a == b && c == d) {
                    p = a;
                    q = c;
                } else {
                    p = a;
                    q = b;
                }
                score = (p + q) * (Math.abs(p - q));
            }
            // c4: 같은 두 값 제외한 서로 다른 두 값끼리 곱하여 점수 얻는 경우
            else if ((a == b && c != d && a != c) || (a == c && b != d && a != b) || (a == d && c != b && a != c)) {
                if (a == b) {
                    score = c * d;
                } else if (a == c) {
                    score = b * d;
                } else {
                    score = a * d;
                }
            }
            // c5: 두 값 중 최솟값 비교하기 메서드 사용하여 네 가지 값 전부 비교하기
            else {
                score = Math.min(Math.min(Math.min(a, b), c), d);
            }

        return score;
    }
    public static int findDifferentNumber(int a, int b, int c, int d) {
        if (a == b && b == c && c != d) {
            return d;
        } else if (a == b && b == d && d != c) {
            return c;
        } else if (a == c && c == d && d != b) {
            return b;
        } else {
            return a;
        }
    }
}

/**
 * 코드 실행만 했을 때에는 통과됐지만,
 * 제출 후 채점하기 에서는 채점 결과
 * 정확성: 73.8
 * 합계: 73.8 / 100.0
 * 으로 제출에 실패했습니다.
 */
