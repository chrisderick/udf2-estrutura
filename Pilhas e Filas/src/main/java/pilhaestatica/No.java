package pilhaestatica;

class No {
    private Integer valor;
    private int index;

    No(Integer valor, int index) {
        this.valor = valor;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    Integer getValor() {
        return valor;
    }

    void setValor(Integer valor) {
        this.valor = valor;
    }

}
