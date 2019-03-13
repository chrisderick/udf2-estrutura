package pilhadinamica;

import java.util.Scanner;

class PilhaDinamicaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Implementação da Pilha Dinamica
        PilhaDinamica stack = new PilhaDinamica();
        //Métodos da pilha (O método isEmpty está na classe PilhaDinamica)
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.peek();
        stack.pop();
        stack.peek();
    }
}
