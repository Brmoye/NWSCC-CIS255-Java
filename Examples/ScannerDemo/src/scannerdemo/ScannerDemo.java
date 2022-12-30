package scannerdemo;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner inputDevice = new Scanner(System.in);
        String name;
        int age;
        inputDevice.useDelimiter("\n");
        
        System.out.print("Please enter your age: ");
        age = inputDevice.nextInt();
        
        System.out.print("Please enter your name: ");
        name = inputDevice.next();
        
        System.out.println("Your name is " + name + " and you are " + age + " years old.");
    }
}
