package filaestatica;

class No {
    private String nome;
    private No proximo;

    String getNome() {
        return nome;
    }

    void setNome(String nome) {
        this.nome = nome;
    }

    No getProximo() {
        return proximo;
    }

    void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
