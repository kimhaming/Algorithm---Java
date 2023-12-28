package homework.programmers;

public class S120876 {
    //  Todo:   접근방식과 입출력예제에서 알려주는 중요한 포인트 생각하기
    //   1. 매개변수로 주어진 이차원 배열 lines가 나타내는 것은 x좌표의 시작과 끝으로 이루어진 선분이다.
    //   3. y축 값은 없다. a,b 모두 x축 선상에 있음.
    //   4. 입출력 예제 3가지 경우 모두 그림으로 나타내보고, 기댓값을 출력하려면 무엇을 포인트로 잡아야 할지 목적을 분명히 적는다.
    //   5. 포인트(1) 3개의 선분이 모두 겹치는 구간에서도 겹친 길이는 1개로 간주하는 것을 확인할 수 있다.
    //   -> 특정 좌표에서 겹칠 때마다 count++ 한다. (포인트를 알고 정의하기)
    //   6. 포인트(2) 주어진 int answer를 리턴하기롤 기대하고 있으니 answer에 겹치는 부분의 길이를 담는다.
    //   7. 그리고, 현재 x좌표의 범위는 -100 부터 100까지인데 우리는 겹치는 갯수만 알면 되고, 특정 좌표를 배열의 인덱스로 간주하여
    //   -> 해당 좌표를 지날 때마다 해당 인덱스 배열 값을 ++ 해줄 것이기 때문에 배열은 인덱스 0부터 시작이므로 범위에 +100 치환해준다.
    //   8. 좌표 (a1, b1) 한 개씩 돌면서 a1에 해당하는 자리부터 b1에 해당하는 자리까지 채우면 배열에 선분처럼 표시되는 것을 그림으로 확인할 수 있다.
    //   9. 해당 배열에 자리를 채운다는 것 = 해당 인덱스 값을 ++ 해주는 것 -> 해당 인덱스 값을 꺼내봤을 때, 1이면 겹치는 선분 X 2 이상이면 겹치는 선분 O
    //   10. 구하고자 하는 것은 한 자리에서 선분 2개가 겹치는지 3개가 겹치는지가 아니라, 몇 개가 됐든 2개 이상 겹치는 선분의 길이 이다.

    public static void main(String[] args) {
        int[][] lines = {{-1, 1}, {1, 3}, {3, 9}};
        System.out.println(solution(lines));
    }

    public static int solution(int[][] lines) {

        int answer = 0; // 겹친 부분 수
        int[] arr = new int[200];    // 인덱스 호출했을 때 2이상 저장되어있는 개수 확인할 배열

        // 2차원 배열 lines를 1차원 배열 line 단위로 돌면서
        for (int[] line : lines) {
            // 1차원 배열 line은 x좌표를 뜻하며 -100 부터 100 까지의 범위의 좌표값을 띤다.
            // 얼마나 겹치는가를 보기 위해 해당 x축을 크기가 200인 배열로 치환한다. a = line[0], b = line[1]
            // 조건식에서 마지막 좌표를 범위에서 제외하는 이유는 j를 새로운 배열 arr의 인덱스로 사용할 것이기 때문
            // 좌표의 범위가 -100 부터 100까지이고 이를 +100 해주면 0부터 199까지의 새로운 배열 인덱스로 사용 가능
            // 배열의 인덱스는 0부터 시작하여 배열의 길이보다 1 작은 값까지의 범위를 가진다.
            for (int j = (line[0] + 100); j < (line[1] + 100); j++) {
                // 새로운 배열에 인덱스로 저장해준다.
                arr[j]++;
            }
        }
        // 배열 arr에서 값을 하나씩 꺼내며 배열의 끝까지 반복한다.
        for (int value : arr) {
            // 해당 값이 1 초과이면 (같은 인덱스를 선분 2개 이상이 거쳤다는 뜻)
            if (value > 1) {
                // 겹치는 선분의 길이가 1 -> 발견할 때마다 answer에 쌓아주기 (answer는 총 겹친 수 = 길이 가 된다.)
                answer++;
            }
        }
        // 리턴타입이 int인 함수 내부에서 int 값을 리턴해줘야 한다.
        return answer;
    }
}
