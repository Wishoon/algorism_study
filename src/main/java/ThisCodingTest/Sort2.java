package ThisCodingTest;

public class Sort2 {
    /*
        삽입 정렬은 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입합니다.
        선택 정렬에 비해 구현 난이도가 높은 편이지만, 일반적으로 더 효율적으로 동작

        1. 첫 번째 데이터는 그 자체로 정렬이 되어 있다고 판단하고, 두 번째 데이터가 어떤 위치로 들어가야 할지를 판단. 즉, 첫번째의 왼쪽인지 오른쪽인지 두 가지의 경우를 파악
        2. 세 번째 데이터가 어떤 위치로 들어가야 할지를 판단. 즉, 총 3가지의 경우가 생김
        3. 이를 계속 반복한다.

        -> 결론 삽입 정렬의 시간 복잡도는 O(n의 2제곱)이며, 선택 정렬과 마찬가지로 반복문이 두 번 중첩되어 사용된다.
            삽입 정렬은 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작.(최선의 경우 O(n))
     */
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            // 인덱스 i부터 1까지 감소하며 반복하는 문법
            for (int j = i; i > 0; j--) {
                // 한 칸씩 왼쪽으로 이동
                if (arr[j] < arr[j-1]){
                    // 스와프
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = temp;
                }
                // 자기보다 작은 데이터를 만나면 그 위치에서 탈출
                else break;
            }
        }
        for (int i=0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
