package com.rishahtech.java8.placement.company.Newgen.code;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
//		0,1,1,2,3,5,7..........n

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Ending Number  ");
        int num = sc.nextInt();

        fibonacci(num);

    }

    private static void fibonacci(int n) {
        int n1, n2;
        n1 = 0;
        n2 = 1;
        System.out.print("0,1,");
        for (int i = 0; i < n - 2; i++) {
            int sum = n1 + n2;
            System.out.print(sum + ",");
            n1 = n2;
            n2 = sum;
        }
    }
}
