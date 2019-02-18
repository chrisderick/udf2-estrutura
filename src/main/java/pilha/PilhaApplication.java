package pilha;

import java.util.Scanner;

public class PilhaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pilha stack = new Pilha();
        stack.push(s.nextInt());
        stack.push(s.nextInt());
        stack.push(s.nextInt());
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
