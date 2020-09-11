# 문제

프로그래머스 코딩테스트연습 > 2019 카카오 개발자 겨울 인턴쉽 > 크레인 인형뽑기 게임

https://programmers.co.kr/learn/courses/30/lessons/64061

# 문제풀이

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
		//1번
        List<Integer> basket = new ArrayList<>();
        
		//2번
        for (int i = 0; i < moves.length; i++) {
            for (int j =0; j < board.length; j++){
                if (board[j][moves[i]-1] != 0 ){
                    basket.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
            }
        }
		//3번
        int popNum = 0;
        boolean isPop =true;
        while(isPop){
            isPop =false;
            int previousDoll = 0;
            for (int i = 0; i < basket.size(); i++) {
                if(basket.get(i)==previousDoll){
                    popNum++;
                    basket.remove(i);
                    basket.remove(i-1);
                    isPop =true;
                    break;
                }else{
                    previousDoll =basket.get(i);
                }
            }
        }
		//4번
        if(popNum>0){
            return popNum*2;
        } else{
            return 0;
        }
    }
}
```



- 1번: 인형을 담을 바구니를 ArrayList로 만들어 줍니다
- 2번: 중첩 for문을 만들어 크레인으로 인형을 뽑는 것을 구현합니다
  - mark-1이 가로축을 결정하고 j가 세로축을 결정하게 해서 이중 배열에 값이 0이 아닌 곳에 값을 basket.add로 바구니에 옮겨담습니다
  - 인형을 뽑은 자리는 0을 대입해주어서 다음에 다시 뽑히지 않도록 합니다
- 3번 :  basket 배열의 값을 조사하여 연속된 인형은 터질수 있도록 구현합니다
  - isPop를 만들어 한번이라도 인형이 터졌으면 for문이 반복될 수 있도록 while문을 작성합니다
  - previousDoll에 지난 인형의 번호를 입력하고 현재의 인형의 번호와 같으면 터진횟수를 증가시키고 두 인형을 basket에서 모두 지워주고 반복문을 빠져나오게해서 같은인형이 만나면 터지는 것을 반복해줍니다
- 4번 : 터진 횟수가 0보다 크다면 *2를 해주어서 한번에 2개의 인형이 터지게 된것을 계산해주어 retrun합니다

# 느낀점

- 초금 문제지만 처음으로 풀이를 보지 않고 푼 문제라 기분이 좋았다
- 중복 for문과 반복문에서 전값과 비교해서 현재의 값을 처리하는 방식으로 풀이하였다
  - 처음에 중복 for문에 i,j 값의 위치를 반대로 표기해서 전혀다른 값이 나왔다
  - 위의 문제를 해결하다가 pop이 터져서 다른 pop이 일어날수있는 것을 발견하고 아래 반복문을 수정하였다
  - 아래반복문에서 pop이 안일어날때까지 반복을 해야되서 whil문안에 for문을 사용했는데 while문의 flag를 어디세워야 하나 한참 고민했다
    - 아직은 조금 더 익숙해져야 될 부분이긴 하지만 결국 찾아낸게 기분이 좋았따