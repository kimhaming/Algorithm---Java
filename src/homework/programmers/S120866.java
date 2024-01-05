package homework.programmers;

public class S120866 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }
    /**
     * Todo:
     *  1. (2,2) (2행 2열) 에 지뢰가 있다면 board 배열에 1이 찍힌다.
     *  2. 인접된 행렬들은 위험한 지역으로 여긴다.
     *  3. 총 칸 수 - 1 - 위험한 지역 수 = 안전한 지역 수
     */

    public static int solution(int[][] board) {
        // 2차원 배열 board의 원소의 값은 0또는 1로 이루어져 있다.
        //  행과 열의 크기는 알 수 없지만 서로 같다.

        int count = 0;
        for (int[] row : board) {
            for (int j = row[0]; j < row.length; j++) {
                if (row[j] == 1) {
                    // row[j] 주변을 2로 바꾼다.

                }
                    }
            // 전체 돌았을 때 0인 부분을 찾으면 count++한다.
            for (int j = row[0]; j < row.length; j++) {
                if (row[j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
