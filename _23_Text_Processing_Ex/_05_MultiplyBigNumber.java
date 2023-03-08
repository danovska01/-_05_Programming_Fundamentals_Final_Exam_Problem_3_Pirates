package _23_Text_Processing_Ex;

import java.util.Scanner;

public class _05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //You are given two lines – the first one can be a really big number (0 to 1050).
        // The second one will be a single digit number (0 to 9). You must display the product of these numbers.

        String bigNum = scanner.nextLine().replaceFirst("^0+(?!$)", "");

        if (bigNum.isEmpty()){
            bigNum = "0";
        }

        int num = Integer.parseInt(scanner.nextLine());

        if (num == 0) {
            System.out.println(0);
            return;
        }
        int remainder = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = bigNum.length() - 1; i >= 0; i--) {

            int currentRes = 0;

            if (i == 0) {
                int remaining = Integer.parseInt(String.valueOf(bigNum.charAt(i))) * num + remainder;
                String preReversed = Integer.toString(remaining);

                String reversedNum = new StringBuffer(preReversed).reverse().toString();
                sb.append(reversedNum);
                break;
            }

            if (Integer.parseInt(String.valueOf(bigNum.charAt(i))) * num + remainder < 10) {

                currentRes = Integer.parseInt(String.valueOf(bigNum.charAt(i))) * num + remainder;
                sb.append(currentRes);
                remainder = 0;
            } else {
                currentRes = Integer.parseInt(String.valueOf(bigNum.charAt(i))) * num + remainder;
                sb.append(currentRes % 10);
                currentRes /= 10;
                remainder = currentRes;
            }

        }

        System.out.println(sb.reverse());

            }
}
