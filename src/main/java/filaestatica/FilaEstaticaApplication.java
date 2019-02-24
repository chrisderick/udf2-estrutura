package filaestatica;

public class FilaEstaticaApplication {
    //Resolução da questão 2 de Filas, que visa a implementação de uma Fila Estática
    public static void main(String[] args) {
        //Implementação da Fila Estática
        FilaEstatica fila = new FilaEstatica();
        //Métodos da Fila (Os métodos FilaVazia e FilaCheia se encontram na classe FilaEstatica
        fila.inserir("Yves");
        fila.inserir("Chuu");
        fila.inserir("Go Won");
        fila.inserir("Olivia Hye");
        fila.inserir("Profa. Iasmini");

    }
}
