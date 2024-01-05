package homework.programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class S120876 {
    //  Todo: HashSet 이용하기

    public static void main(String[] args) {
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};

        System.out.println(solution(lines));
    }

    // int형 이차원 배열을 매개변수로 받는 함수 solution 만든다.
    public static int solution(int[][] lines) {
       // 중복, 순서 x Set 인터페이스를 구현한 HashSet 생성하여 나타나는 선분의 위치 담는다.
        Set<Integer> positions = new HashSet<>();

        // 이차원 배열을 순회하며 각 요소를 일차원 배열 변수에 담는다.
        for (int[] line : lines) {
            // 일차원 배열의 첫번째 요소 +100 으로 초기화, 두번째 요소 +100 미만이 될 때까지 순회한다.
            for (int j = (line[0] + 100); j < (line[1] + 100); j++) {
                // 숫자형 집합 positions에 범위에 해당하는 위치를 중복없이 저장한다.
                positions.add(j);
            }
        }

        // pos 하나에 대한 순회가 끝났을 때 count가 2이상인지 확인해서 참이면 중복 선의 개수를 담는 변수 필요하다.
        int intersections = 0;
        // 저장한 위치 하나씩
        for (int pos : positions) {
            int count = 0;
            // 일차원 배열 좌표를 하나씩 순회하며
            for (int[] line : lines) {
                // 일차원 배열의 요소인 특정 선분 범위 사이에 특정 위치가 속한다면,
                if (line[0] + 100 <= pos && pos < line[1] + 100) {
                    // 세어준다.
                    count++;
                }
            }

            // pos 하나에 대한 순회가 끝나고, 새로운 pos로 넘어가서 count가 리셋되기 전에, 같은 pos에 대한 count가 2이상이라면
            if (count > 1) {
                // 겹치는 선의 개수를 뜻하는 변수의 값을 1 증가시킨다.
                intersections++;
            }
        }
        // 모든 pos에 대한 순회가 끝나면 intersection을 리턴한다.
        return intersections;
    }
}
