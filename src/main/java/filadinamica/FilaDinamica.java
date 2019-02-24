package filadinamica;

import java.util.ArrayList;

class FilaDinamica {
    private ArrayList<No> fila = new ArrayList<No>();
    private No inicioFila;
    private int finalFila = -1;

    @SuppressWarnings("Duplicates")
    void inserir(String nome){
        No novo = new No();
        novo.setNome(nome);
        if (!filaVazia()) {
            fila.get(finalFila).setProximo(novo);
        }
        if (finalFila == -1) {
            inicioFila = novo;
        }
        fila.add(novo);
        System.out.println(novo.getNome() + " entrou na fila.");
        finalFila++;
    }

    void remover(){
        if (filaVazia()){
            System.out.println("A fila está vazia!");
        } else if (finalFila == 0){
            System.out.println(fila.get(0).getNome() + " foi atendido(a)!");
            fila.remove(0);
            finalFila--;
        } else {
            System.out.println(fila.get(0).getNome() + " foi atendido(a)!");
            No proximo = fila.get(0).getProximo();
            fila.set(0, proximo);
            inicioFila = proximo;
        }
    }

    void proximo(){
        if (filaVazia()){
            System.out.println("A fila está vazia!");
        } else {
            System.out.println("Próximo(a) a ser atendido(a): " + inicioFila.getNome() + ".");
            }
        }

    private boolean filaVazia(){
        return fila.isEmpty() || inicioFila == null;
    }

}
