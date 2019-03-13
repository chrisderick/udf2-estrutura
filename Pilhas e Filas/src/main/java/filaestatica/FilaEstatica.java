package filaestatica;

import java.util.ArrayList;

class FilaEstatica {
    private ArrayList<No> fila = new ArrayList<No>(3);
    private No inicioFila;
    private int finalFila = -1;

    FilaEstatica(){
        fila.ensureCapacity(3);
    }

    @SuppressWarnings("Duplicates")
    void inserir(String nome){
        No novo = new No();
        novo.setNome(nome);
        if (filaCheia()) {
            System.out.println("A fila está cheia. Atendendo o próximo da fila...");
            remover();
        }
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

    @SuppressWarnings("Duplicates")
    private void remover(){
            System.out.println(fila.get(0).getNome() + " foi atendido(a)!");
            No next = fila.get(0).getProximo();
            fila.remove(0);
            inicioFila = next;
            finalFila--;
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

    private boolean filaCheia() { return fila.size() == 3;}

}
