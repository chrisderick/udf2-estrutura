package filadinamica;

import java.util.Scanner;

public class FilaDinamicaApplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Implementação da Fila
        FilaDinamica fila = new FilaDinamica();
        System.out.println("Insira o nome da pessoa: ");
        //Métodos da Fila (O método Fila Vazia se encontra na classe Fila)
        fila.inserir("HeeJin");
        fila.inserir("HyunJin");
        fila.proximo();
        fila.remover();
        fila.proximo();
        fila.inserir("Vivi");
        fila.remover();
        fila.proximo();
        fila.remover();
        fila.remover();
        fila.proximo();

    }
}
