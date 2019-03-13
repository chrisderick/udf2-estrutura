package br.edu.udf.lista;

public class Lista {
    private String[] elementos; //Declarando Vetor
    private int tamanho;

    public Lista(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    //Adicionar ao final da lista
    public boolean adicionar(String elemento) {
        this.aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[tamanho] = elemento;
            tamanho++;
            return true;
        }
        return false;
    }

    //Verificar tamanho
    public int tamanho() {
        return tamanho;
    }

    //Imprimir elementos
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0){
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }

    //Buscar elemento
    public String busca(int posicao){
        if(posicao >=0 && posicao < this.tamanho){
            return this.elementos[posicao];
        } else {
            throw new IllegalArgumentException("Posição inválida!");
        }
    }

    //Verificar se um elemento existe na lista
    public Integer busca(String valor){
        for (int i=0; i < this.tamanho; i++){
            if(this.elementos[i].equals(valor)){
                return i;
            }
        }
        return null;
    }

    //Adicionar elemento numa posição específica
    public boolean adicionar(int posicao, String elemento){
        //Mover os elementos
        if(posicao >=0 && posicao < this.tamanho){
            for (int i = this.tamanho-1; i >= posicao; i--){
               this.elementos[i+1] = this.elementos[i];
            }
            this.aumentarCapacidade();
            //Adicionar elemento na posição
            this.elementos[posicao] = elemento;
            this.tamanho++;
            return true;
        } else {
            throw new IllegalArgumentException("Posição inválida!");
        }
    }

    //Aumentar capacidade
    private void aumentarCapacidade(){
        if(this.tamanho == this.elementos.length){
            String[] elementosNovos = new String[this.elementos.length*2];
            for (int i = 0; i < this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    //Remover elemento
    public void remover(int posicao) {
        if (posicao >= 0 && posicao < this.tamanho) {
            for (int i = posicao; i < tamanho; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
        }
    }
}

