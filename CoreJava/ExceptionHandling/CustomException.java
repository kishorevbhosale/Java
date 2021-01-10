package CoreJava.ExceptionHandling;


import java.util.Scanner;

/**
 * Creating own exception example
 */

class MyRuntimeException extends RuntimeException {
    MyRuntimeException(String s) {
        super(s);
    }
}

class MyException extends Exception {
    MyException(String s) {
        super(s);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int demoninator = sc.nextInt();
        if (demoninator == 0) {
            try {
                System.out.println("Calling to custom exception...");
                throw new MyException("Denominator as 0 is not allowed");
            } catch (MyException myException) {
                myException.printStackTrace();
            }
        }

        try {
            if (demoninator < 5) {
                throw new MyRuntimeException("Runtime exception - divide by less than 5 is not allowed...");
            } else {
                int result = 100 / demoninator;
                System.out.println("100/" + demoninator + "=" + result);
            }
        } catch (MyRuntimeException myException) {
            myException.printStackTrace();
        }

    }
}


/*

Output -

Test1:
0
Calling to custom exception...
CoreJava.ExceptionHandling.MyException: Denominator as 0 is not allowed
	at CoreJava.ExceptionHandling.CustomException.main(CustomException.java:31)
CoreJava.ExceptionHandling.MyRuntimeException: Runtime exception - divide by less than 5 is not allowed...
	at CoreJava.ExceptionHandling.CustomException.main(CustomException.java:39)

Test2:
2
CoreJava.ExceptionHandling.MyRuntimeException: Runtime exception - divide by less than 5 is not allowed...
	at CoreJava.ExceptionHandling.CustomException.main(CustomException.java:39)


 */