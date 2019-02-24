package reversordepalavras;

import java.util.Scanner;

//Exercício 2 das Pilhas, feito de forma estruturada
class ReverseWordApplication {
    public static void main(String[] args) {
        //Input da Palavra
        Scanner s = new Scanner(System.in);
        System.out.print("Digite uma palavra e ela será revertida: ");
        String palavra = s.nextLine();

        //Declaração da Pilha
        String[] pilha = new String[palavra.length()];

        //Push na Pilha
        int palavraIndex = palavra.length()-1;
        for (int i = 0; i < pilha.length; i++) {
            pilha[i] = String.valueOf(palavra.charAt(palavraIndex--));
        }

        //Peek da Pilha
        String palavraReversa = "\n =======================\n Palavra ao Reverso: ";
        for (String s1 : pilha) {
            palavraReversa += s1;
        }
        System.out.println(palavraReversa);
    }
}
