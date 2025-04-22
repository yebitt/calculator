package lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();  // 연산 결과를 저장하는 컬렉션 타입 필드

    // 사칙연산 수행 후, 결과값을 반환하는 메서드
    public int calculate(int num1, int num2, char operator){
        switch (operator) {
            case '+':
                results.add(num1 + num2);
                break;
            case '-':
                results.add(num1 - num2);
                break;
            case 'x':
                results.add(num1 * num2);
                break;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    // main()에서 try-catch문 작성
                }
                results.add(num1 / num2);
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자 입니다.");
        }

        return results.get(results.size()-1);
    }
}
