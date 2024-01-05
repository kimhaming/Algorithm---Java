package homework.programmers;

public class S120875 {
    public static void main(String[] args) {

        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {

        int x1, x2, x3, x4 = 0;
        int y1, y2, y3, y4 = 0;

        for (int i = 0; i < dots.length; i++) {   // 길이가 4인 이차원 배열을 돌면서
            for (int j = i + 1; j < dots.length; j++) { // 중복되지 않으려고 위에서 x1이 정해지면 x2는 최소 x1의 다음 순서이기 때문에
                for (int a = j + 1; a < dots.length; a++) { // 실행 순서가 먼저인 외부 for문보다 내부 for문에서의 시작점을
                    for (int b = a + 1; b < dots.length; b++) { // +1 해준다.
                        x1 = dots[i][0];
                        y1 = dots[i][1];
                        x2 = dots[j][0];
                        y2 = dots[j][1];
                        x3 = dots[a][0];
                        y3 = dots[a][1];
                        x4 = dots[b][0];
                        y4 = dots[b][1];

                        // 두 직선의 기울기 구하기
                        double gradient1 = (double) (y2 - y1) / (x2 - x1);
                        double gradient2 = (double) (y4 - y3) / (x4 - x3);

                        if (gradient1 == gradient2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
        return 0;   // return 쓰도록 에러 메시지가 떴다. 중괄호의 위치를 살펴보니 첫번째 외부 for문의 조건식에 해당하지 않을 경우에 바로 0을 리턴한다.
    }
        }
/**
 * 평행이 되는 조건: 입출력 예를 보면, x3 - x1 = x4 - x2, y3 - y1 = y4 - y2 이다.
 * dots.length == 4
 * dots[i].length == 2
 * 근데 평행이 되는 조건으로 위 규칙대로 찾아내기에는 꼭 3과 1자리가 아닐 수도 있기 때문에 다른 방법을 찾아보자.
 * 평행이라면, 두 직선의 기울기가 똑같다. 기울기가 똑같다면 1을 리턴하고, 아니면 0을 리턴한다.
 * 겹치는 점이 없다. = 같은 좌표는 없다.
 * 두 직선이 겹치는 경우 1 리턴 = 겹치더라도 좌표가 서로 다를 수 있고, 같은 직선 위에 있기 때문에 기울기가 같다.
 */
