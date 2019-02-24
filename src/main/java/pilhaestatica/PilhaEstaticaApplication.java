package pilhaestatica;

import java.util.Scanner;

class PilhaEstaticaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Declaração da pilha e atribuição do seu tamanho no parâmetro do construtor.
        PilhaEstatica stack = new PilhaEstatica(3);

        //Métodos da pilha (Os métodos isFull e isEmpty estão na classe PilhaEstatica).
        stack.push(8);
        stack.push(3);
        stack.push(1);
        stack.pop();
        stack.peek();
        stack.pop();
        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.peek();
    }
}
