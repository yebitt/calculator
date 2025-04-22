package lv2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2;
        char operator;
        int result = 0;
        String userInput = "";
        Calculator calculator = new Calculator();

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

            System.out.print("계속 진행을 원하시면 enter를, 종료를 원하시면 exit을 입력하십시오 > ");
            userInput = s.nextLine();
            if(userInput.equals("exit")) {
                System.out.println("이용해 주셔서 감사합니다.");
                break;
            }
        }
    }
}
