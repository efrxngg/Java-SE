package edu.java.se.functional;

public class FunctionalInteface {

    @FunctionalInterface
    interface StringOperator {

        int getAmount();

        // Nos permite definir el cuerpo de un metodo para una interface
        default void operate(String txt) {
            int x = getAmount(), c = 1;

            while (c <= x) {
                System.out.println(String.format("%" + c + "s", txt));
                c++;
            }
        }
    }

    public static void main(String[] args) {
        StringOperator six = () -> 6;
        six.operate("x");

        DoOperation op = (txt) -> System.out.println(txt);
        op.run(6, "x");
    }

    @FunctionalInterface
    interface DoOperation {

        void take(String txt);

        default void run(int r, String txt) {
            while (r >= 1) {
                take(String.format("%" + r + "s", txt, r));
                r--;
            }
        }
    }

}
