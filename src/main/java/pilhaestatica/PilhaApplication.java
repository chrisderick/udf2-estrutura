package pilhaestatica;

import java.util.Scanner;

class PilhaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PilhaEstatica stack = new PilhaEstatica(2);
        stack.push(4);
        stack.push(5);
        stack.push(10);
        stack.peek();

    }
}
