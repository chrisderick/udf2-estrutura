package pilhadinamica;

class No {
    private int num;
    private No previous;

    int getNum() {
        return num;
    }

    void setNum(int num) {
        this.num = num;
    }

    No getPrevious() {
        return previous;
    }

    void setPrevious(No previous) {
        this.previous = previous;
    }
}
