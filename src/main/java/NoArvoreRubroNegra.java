public class NoArvoreRubroNegra {
    private int valor;
    private Cores cor;
    private NoArvoreRubroNegra direita;
    private NoArvoreRubroNegra esquerda;
    private NoArvoreRubroNegra parent;

    public NoArvoreRubroNegra(int valor) {
        this.valor = valor;
        this.cor = Cores.PRETO;
        this.direita = null;
        this.esquerda = null;
        this.parent = null;
    }

    public NoArvoreRubroNegra getParent() {
        return parent;
    }

    public void setParent(NoArvoreRubroNegra parent) {
        this.parent = parent;
    }

    public int getValor() {
        return valor;
    }

    public NoArvoreRubroNegra getDireita() {
        return direita;
    }

    public void setDireita(NoArvoreRubroNegra direita) {
        this.direita = direita;
    }

    public NoArvoreRubroNegra getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreRubroNegra esquerda) {
        this.esquerda = esquerda;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Cores getCor() {
        return cor;
    }

    public void setCor(Cores cor) {
        this.cor = cor;
    }
}
