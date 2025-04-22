package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2;
        char operator;
        int result = 0;
        String userInput = "";
        Calculator calculator = new Calculator();
        List<Integer> numList = new ArrayList<>();
        int index, changeNum;

        // 4. “exit” 문자열을 입력하기 전까지 무한으로 계산 기능
        while(true) {
            // 1. 양의 정수 입력 기능
            while (true) {
                System.out.print("첫 번째 숫자 입력 : ");
                num1 = s.nextInt();
                System.out.print("두 번째 숫자 입력 : ");
                num2 = s.nextInt();

                if ((num1 >= 0) && (num2 >= 0)) break;
                else System.out.println("잘못된 숫자 입력 - 양의 정수를 입력하세요");
            }

            // 2. 사칙연산 입력받기 기능
            // 3. 연산과 결과값 출력 기능
            while (true) {
                System.out.print("사칙연산 기호(➕,➖,✖\uFE0F,➗) 입력 : ");
                operator = s.next().charAt(0);
                s.nextLine(); // 버퍼 비우기

                // 예외 처리
                try{
                    result = calculator.calculate(num1, num2, operator);
                } catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                    break;
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
                break;
            }

            // getter 메서드 사용
            numList = calculator.getResults();
            System.out.println("================================");
            System.out.print("History : ");
            for (Integer data : numList){
                System.out.print(data + " ");
            }
            System.out.println("\n================================");

            // 메뉴 - history 수정, 종료
            System.out.print("[MENU] 1. 계속 (enter) 2. history 수정 (change) 3. history 삭제 (remove) 4. 종료 (exit) > ");
            userInput = s.nextLine();

            if(userInput.equals("change")){  // setter 메서드 사용
                System.out.print("수정 인덱스 : ");
                index = s.nextInt();
                System.out.print("수정 숫자 : ");
                changeNum = s.nextInt();

                calculator.setResults(index, changeNum);

                System.out.print("수정된 History : ");
                for (Integer data : numList){
                    System.out.print(data + " ");
                }
                System.out.println();
            }
            else if(userInput.equals("remove")){  // 삭제 메서드 사용
                calculator.removeResults();

                System.out.print("수정된 History : ");
                for (Integer data : numList){
                    System.out.print(data + " ");
                }
                System.out.println();
            }
            else if(userInput.equals("exit")) {
                System.out.println("이용해 주셔서 감사합니다.");
                break;
            }
        }
    }
}
