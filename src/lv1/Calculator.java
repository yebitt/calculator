package lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num1, num2;

        while(true) {
            System.out.print("첫 번째 숫자 입력 : ");
            num1 = s.nextInt();
            System.out.print("두 번째 숫자 입력 : ");
            num2 = s.nextInt();

            if((num1 >= 0) && (num2 >= 0)) break;
            else System.out.println("잘못된 숫자 입력 - 양의 정수를 입력하세요");
        }
    }
}
