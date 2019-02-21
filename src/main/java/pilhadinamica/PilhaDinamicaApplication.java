package pilhadinamica;

import java.util.Scanner;

class PilhaDinamicaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PilhaDinamica stack = new PilhaDinamica();
        stack.push(8);
        stack.push(8);
        stack.push(8);
        System.out.println(stack.peek());
    }
}
